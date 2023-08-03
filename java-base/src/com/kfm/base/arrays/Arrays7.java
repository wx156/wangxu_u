package com.kfm.base.arrays;

public class Arrays7 {
    public static void main(String[] args) {
        char[][] poem = {
                {'十', '年', '生', '死', '两', '茫', '茫', '\u002C', '不', '思', '量', '\u002C', '自', '难', '忘'},
                {'千', '里', '孤', '坟', '\u002C', '无', '处', '话', '凄', '凉', '\u3002'}, // 1 11
                {'纵', '使', '相', '逢', '应', '不', '识', '\u002C', '尘', '满', '面', '\u002C', '鬓', '如', '霜'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡', '\u002C', '小', '轩', '窗', '\u002C', '正', '梳', '妆'},
                {'相', '顾', '无', '言', ',', '惟', '有', '泪', '千', '行', '\u3002'},
                {'料', '得', '年', '年', '肠', '断', '处', '\u002C', '明', '月', '夜', '\u002C', '短', '松', '冈'}
        };
        int max = poem[0].length;

        for (int i = 0; i < poem.length; i++) {
            if (poem[i].length > max){
                max = poem[i].length;
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = poem.length-1; j >= 0; j--) {
                if (i >= poem[j].length){
                    System.out.print(" "+"\t");

                }else
                    System.out.print(poem[j][i] + "\t");

            }
            System.out.println();

        }
    }
}
