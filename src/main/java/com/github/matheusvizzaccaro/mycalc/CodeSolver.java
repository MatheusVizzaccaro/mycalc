package com.github.matheusvizzaccaro.mycalc;

public class CodeSolver {
    public int solveCode (CalcCode code) {
        if(solveParenthesis())
    }

    public int solveParenthesis(CalcCode code) {
        int startIdx = 0, finalIdx = 0;
        if(code.calcCode.contains("(")) {
            int fPrt = code.calcCode.indexOf("(");
            int chk = code.calcCode.lastIndexOf("(");
            if(fPrt == chk) {
                startIdx = fPrt + 1;
                finalIdx = chk - 1;
                CalcCode content = new CalcCode(code.calcCode.substring(startIdx, finalIdx));
                solveParenthesis(content);
            }
        } else {
          // ver oq retornar
        }
    }
}
