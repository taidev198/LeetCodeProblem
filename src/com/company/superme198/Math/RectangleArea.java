package com.company.superme198.Math;

public class RectangleArea {


    static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOfRec1 = Math.abs(A - C) * Math.abs(B - D);
        int areaOfRec2 = Math.abs(E - G) * Math.abs(F - H);
        int areaOfInjection ;
        if(!((( C > E && C >= G && A <G )||
                ( G > A && G >= C && E <C )) &&
                (( D > F && D >= H && B < H )||
                        ( H > B && H >= D && F < D )))
        ){
            areaOfInjection = 0;
        }

        else{
            if(C <= G && A >= E && D <= H && B >= F)
                return areaOfRec2;
            if(G <= C && E >= A && H <= D && F >= B)
                return areaOfRec1;
            if (C <= G && A >= E)
                areaOfInjection = Math.abs(C-A) * Math.abs(H - D);
           else if(( G > A && G >= C && E <C ) && ( D > F && D >= H && B < H ))
                areaOfInjection = Math.abs(C-E) * Math.abs(H -B);
            else if( ( G > A && G >= C && E <C ) && ( H > B && H >= D && F < D ))
                areaOfInjection = Math.abs(C-E) * Math.abs(F -D);
            else if(( C > E && C >= G && A <G ) && ( D > F && D >= H && B < H ))
                areaOfInjection = Math.abs(A-G) * Math.abs(H -B);
            else  areaOfInjection = Math.abs(A-G) * Math.abs(F -D);
        }
        if(areaOfRec1 == 0)
            return areaOfRec2;
        if(areaOfRec2 == 0)
            return areaOfRec1;

        return areaOfRec1 + areaOfRec2 - areaOfInjection;

    }



    public static void main(String...args){
        System.out.println(computeArea(-2, -2 , 2, 2, -3,-3, 3 ,-1));
    }
}
