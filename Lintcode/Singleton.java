class Solution {
    /**
     * @return: The same instance of this class every time
     */
    
    private static Solution solution;
    private Solution(){
        
    }
    
    public static Solution getInstance() {
        // write your code here
        if(solution == null){
            solution = new Solution();
        }
        return solution;
        
    }
};