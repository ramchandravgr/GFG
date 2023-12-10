//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
     ArrayList<String> ans = new ArrayList<String>();
    public  ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        //Solution sol = new Solution();
        
        func(m,n,0,0,"");
        return ans;
    }
    public void func(int[][] m,int n,int i,int j,String curr)
    {
        //Base condition
        if(i==n-1 && j==n-1)
        {
            if(m[i][j]==1)
            {
                ans.add(curr);
                return;
            }
        }
        
        if(i<0 || j<0 || i>=n || j>=n || m[i][j] == 0)
        {
            return;
        }
        
        m[i][j] = 0;
        
        //right
        func(m,n,i,j+1,curr+"R");
        //up
        func(m,n,i-1,j,curr+"U");
        //down
        func(m,n,i+1,j,curr+"D");
        //left
        func(m,n,i,j-1,curr+"L");
        
        //backtrack
        m[i][j] = 1;
        
    }
}