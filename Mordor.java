/**
 * ODOC _ 1st commit
 * @author: Sean Lee
 * @Document written 2020.02.25
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Mordor: Main class
 *  @main: collect input and run methods
 */
class Mordor{
    public static void main(String[] args) throws IOException{
        /**
         * main: collect input and run methods
         * @ param int c : how many rounds to run
         * @ param int n = numbers of signs
         * @ param int 
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        while(c-->0){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] nArray = new int[n];
            s = br.readLine();
            st = new StringTokenizer(s);
            for(int j=0;j<n;j++) nArray[j]=Integer.parseInt(st.nextToken());
            RMQ minRMQ = new RMQ(nArray);
            for(int j=0;j<n;j++) nArray[j]*=-1;
            RMQ maxRMQ = new RMQ(nArray);
            for(int j=0;j<q;j++){
                s = br.readLine();
                st = new StringTokenizer(s);
                int no1 = Integer.parseInt(st.nextToken());
                int no2 = Integer.parseInt(st.nextToken());
                System.out.println(maxRMQ.query(no1,no2)*-1 - minRMQ.query(no1,no2));
            }
        }
    }
}

/**
 * 
 */

 class RMQ{
     private final int INF = 987654321;
     private int n;
     private int minRange[];
     

     public RMQ(int[] arr){
         n = arr.length;
         minRange = new int[4*n];
         init(arr,0,n-1,1);
     }
     private int init(int[] arr, int left, int right, int node){
         if(left==right) return minRange[node] = arr[left];
         int mid = (left+right)/2;
         int minLeft= init(arr,left,mid,node*2);
         int minRight = init(arr,mid+1,right,node*2+1);
         return minRange[node] = min(minLeft,minRight);
     }

     public int min(int a, int b){
         return (a>b)?b:a;
     }

     public int query(int left, int right){
         return query(left,right,1,0,n-1);
     }

     public int query(int left, int right, int node, int leftNode, int rightNode){
         if(right<leftNode || left>rightNode) return INF;
         if(left <= leftNode && rightNode <= right) return minRange[node];
         int mid = (leftNode + rightNode) / 2;
         return min(query(left, right, node*2, leftNode, mid),query(left,right,node*2+1, mid+1, rightNode));
     }
 }