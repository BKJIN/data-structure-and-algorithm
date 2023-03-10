package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ν°λ 
//( (π₯β - π₯β)Β² + (π¦β - π¦β)Β² )Β½  μ κ΅¬νκΈ° μν΄ double νμΌλ‘ λ³μλ₯Ό μ μΈ νμ§λ§μ.
//μ’νλ₯Ό λΉκ΅ν  λ μ°λ¦¬λ == μ°μ°μλ₯Ό μ¨μΌνλλ° double ν(λλ floatν) μ κ²½μ°λ μ½κ°μ μ€μ°¨κ° λ°μν  μ μλ€.
//μ΄λ λΆλμμμ  νμμ΄ μ νν κ°μ΄ μλλΌ κ·Όμ¬μΉλ‘ μ²λ¦¬νκΈ° λλ¬Έ
//μ΄λ¬ν νΉμ±μΌλ‘ μΈν΄ μ‘°κΈμ μ€μ°¨κ° μμ κ²½μ° λ μ€μλ κ°μ§ μμ μλ μλ€.
public class Ex1002_a {
    //μ μ  κ°μ κ΅¬νλ λ©μλ
    static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance_pow=(int)(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)); //μ€μ κ³Ό κ±°λ¦¬ distanceμ μ κ³±
        if(x1==x2 && y1==y2 && r1==r2) { //μ€μ μ΄ κ°μΌλ©΄μ λ°μ§λ¦λ κ°μ κ²½μ°
            return -1;
        } else if(distance_pow>Math.pow(r1+r2,2)) { //λ μμ λ°μ§λ¦μ ν©λ³΄λ€ μ€μ κ° κ±°λ¦¬κ° λ κΈ΄ κ²½μ°
            return 0;
        } else if(distance_pow<Math.pow(r1-r2,2)) { //μ μμ μμ΄ μμΌλ λ΄μ νμ§ μμ κ²½μ°
            return 0;
        } else if(distance_pow==Math.pow(r1-r2,2)) { //λ΄μ 
            return 1;
        } else if(distance_pow==Math.pow(r1+r2,2)) { //μΈμ 
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-->0) {
            st = new StringTokenizer(br.readLine());

            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int r1=Integer.parseInt(st.nextToken());

            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int r2=Integer.parseInt(st.nextToken());

            sb.append(tangent_point(x1,y1,r1,x2,y2,r2)+"\n");
        }
        System.out.println(sb);
    }
}
