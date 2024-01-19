var createCounter = function(init) {
    let count = init;
    return {
        increment: () => {
            count++;
            return count;
        },

        decrement: () => {
            count--;
            return count;
        },

        reset: () => {
            count = init
            return count;
        }
    }
};