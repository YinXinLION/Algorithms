package com.lion.think.huishuo;

public class Pattern {
    private boolean matched = false;
    private char[] pattern; //正则表达式
    private int plen; //正则表达式长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    public void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched == true) {
            return;
        }
        if (pj == plen) {
            if (ti == tlen) {
                matched = true;
            }

            return;
        }
        if (pattern[pj] == '*') { //*匹配任意一个字符
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti+k, pj+1, text, tlen);
            }
        } else if (pattern[pj] == '?') { //?匹配0个或1个字符
            rmatch(ti, pj+1, text, tlen);
            rmatch(ti+1, pj+1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) { //纯字符匹配
            rmatch(ti+1, pj+1, text, tlen);
        }
    }
}
