/**
 * @param {number} n
 * @return {number}
 */

const MOD = BigInt(1000000007)
var countGoodNumbers = function(n) {
    const a = power(BigInt(5), parseInt(n/2));
    const b = power(BigInt(4), parseInt(n/2));
    if(n%2 == 0) {
        return (a*b)%MOD;
    } else {
        return (BigInt(5)*a*b)%MOD;
    }
    
};

var power = function(x, n) {
    if(n == 0) {
        return BigInt(1);
    }

    if(n == 1) {
        return x;
    }

    const temp = power(x,parseInt(n/2))%MOD;
    if(n%2 == 0) {
        return temp*temp;
    } else {
        return x*temp*temp;
    }
}