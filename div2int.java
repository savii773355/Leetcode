class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        int quotient = 0;
        while (dividend <= divisor) {
            int currentDivisor = divisor;
            int numSubtractions = 1;
            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && dividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;  
                numSubtractions <<= 1; 
            }
            dividend -= currentDivisor;
            quotient += numSubtractions;
        }
        return isNegative ? -quotient : quotient;
    }
}
