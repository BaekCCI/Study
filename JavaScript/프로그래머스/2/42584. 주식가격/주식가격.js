function solution(prices) {
    const answer = new Array(prices.length).fill(0);
    const stack = [];

    for (let i = 0; i < prices.length; i++) {
        while (stack.length > 0 && prices[i] < prices[stack[stack.length - 1]]) {
            const topIndex = stack.pop();
            answer[topIndex] = i - topIndex;
        }
        stack.push(i);
    }
    
    const lastIndex = prices.length - 1

    while (stack.length > 0) {
        const topIndex = stack.pop();
        answer[topIndex] = lastIndex - topIndex;
    }

    return answer;
}
