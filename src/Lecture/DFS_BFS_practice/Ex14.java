package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Point {
//    public int x, y;
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

//섬나라 아일랜드(BFS)
public class Ex14 {

    static int answer=0,n;
    static int[] dx={-1,-1,-1,0,1,1,1,0};
    static int[] dy={-1,0,1,1,1,0,-1,-1};
    static int[][] board;

    public static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<8; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1) {
                    board[nx][ny]=0;
                    Q.offer(new Point(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==1) {
                    answer++;
                    board[i][j]=0;
                    BFS(i,j);
                }
            }
        }
        System.out.println(answer);
    }
}
