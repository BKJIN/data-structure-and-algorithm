package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x,y,r;
    Point(int x, int y, int r) {
        this.x=x;
        this.y=y;
        this.r=r;
    }
}

//ν°λ 
//( (π₯β - π₯β)Β² + (π¦β - π¦β)Β² )Β½  μ κ΅¬νκΈ° μν΄ double νμΌλ‘ λ³μλ₯Ό μ μΈ -->μ΄λ κ² νμ§λ§κ³  aμ²λΌ νμ΄
public class Ex1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            Point a = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            Point b = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            double distance=Math.sqrt(Math.pow(Math.abs(a.x-b.x),2)+Math.pow(Math.abs(a.y-b.y),2)); //double μμ°λ©΄ νλ¦Ό
            if(distance==0) { //μ€μ¬μ΄ κ°μ λ
                if(a.r==b.r) {
                    sb.append(-1+"\n"); //μ€μ¬μ΄ κ°κ³  ν¬κΈ°κ° κ°μ μ
                } else {
                    sb.append(0+"\n"); //ν μμ΄ λ€λ₯Έ μμμ ν¬ν¨
                }
            } else { //μ€μ¬μ΄ λ€λ₯Ό λ
                if(distance<a.r+b.r) {
                    if(distance+a.r<b.r || distance+b.r<a.r) { //μ€μ¬μ λ€λ₯΄μ§λ§ ν μμ΄ λ€λ₯Έ μμμ ν¬ν¨(μ μ X)
                        sb.append(0+"\n");
                    } else if(distance+a.r==b.r || distance+b.r==a.r){ //μ€μ¬μ λ€λ₯΄μ§λ§ ν μμ΄ λ€λ₯Έ μμμ ν¬ν¨λΌμμΌλ©° μ μ μ΄ νλ μμ
                        sb.append(1+"\n");
                    } else { //μ€μ¬μ΄ λ€λ₯Έ λ μ μ΄ κ²Ήμ³ μ μ  λκ°
                        sb.append(2+"\n");
                    }
                } else if(distance==a.r+b.r) { //ν μμ΄ λ€λ₯Έ μμ ν¬ν¨νμ§ μκ³  μ μ μ΄ νλ μμ
                    sb.append(1+"\n");
                } else if(distance>a.r+b.r) { //λ μμ΄ λ¨μ΄μ Έ μμ΄ μλ¬΄ μ μ λ μμ
                    sb.append(0+"\n");
                }
            }

        }
        System.out.println(sb);
    }
}
