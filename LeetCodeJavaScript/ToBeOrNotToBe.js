var expect = function(val) {
    return {
        toBe: (newVal) => {
            if (val !== newVal) throw new Error("Not Equal");
            else return true;
        },
        notToBe: (newVal) => {
            if (val === newVal) throw new Error("Equal");
            else return true;
        }
    }
}

//expect(5).toBe(5);
//expect(5).notToBe(5);