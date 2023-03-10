package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//크게 만들기

//틀리기도했음
//반례
//5 1
//54321
public class Ex2812_memoryExceeded {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        String input = br.readLine();
        String answer="";
        int check=n-k;
        while(input.length()!=0) {
            int max=0, idx=0;
            for(int i=0; i<=input.length()-check; i++) {
                if(input.charAt(i)-48>max) {
                    max=input.charAt(i)-48;
                    idx=i;
                }
            }
            answer+=max;
            input=input.substring(idx+1); //String 객체가 불변 즉, 값만 변경하는게 불가능 -> String이 계속 만들어지며 새로운 공간을 차지해 메모리 초과
            check--;
        }
        System.out.println(answer);
    }
}
