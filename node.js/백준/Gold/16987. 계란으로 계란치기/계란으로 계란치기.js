const fs = require("fs");
const path = require("path");
const filePath =
  process.platform === "linux"
    ? "/dev/stdin"
    : path.join(__dirname, "../input.txt");
const input = fs
  .readFileSync(filePath)
  .toString()
  .split("\n")
  .map((v) => v.trim());

const N = Number(input[0]);
const info = input.slice(1, 1 + N).map((v) => v.split(" ").map(Number));

let answer = 0;

function BT(idx, result, count) {

  //마지막 계란이면
  if (idx === N) {
    answer = Math.max(answer, count);
    return;
  }

  //현재 계란
  const [a, b] = result[idx];

  //현재 계란이 깨진 경우
  if (a <= 0) {
    BT(idx + 1, result,count);
    return;
  }

  let canBreak = false;
  for (let i = 0; i < N; i++) {
    //자기 자신이면 깰수 없음
    if (i === idx) continue;

    //새로운 계란
    const [targetA, targetB] = result[i];

    //새로운 계란을 깰 수 있으면
    if (targetA > 0) {
      canBreak = true;
      result[i][0] -= b;
      result[idx][0] -= targetB;

      let tempCnt = 0;
      if (result[i][0] <= 0) tempCnt++;
      if (result[idx][0] <= 0) tempCnt++;

      BT(idx + 1, result, count + tempCnt);

      result[i][0] += b;
      result[idx][0] += targetB;
    }
  }

  //깰 수 있는 계란이 없다면
  if (!canBreak) {
    BT(idx + 1, result, count);
  }
}

BT(0, info, 0);
console.log(answer);
