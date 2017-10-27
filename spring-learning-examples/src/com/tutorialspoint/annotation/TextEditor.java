package com.tutorialspoint.annotation;

/**
 * Created by zhaojin on 10/4/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
public class TextEditor {
    //可以在属性中使用 @Autowired 注释来除去 setter 方法。当时使用 为自动连接属性传递的时候，Spring 会将这些传递过来的值或者引用自动分配给那些属性
    private SpellChecker spellChecker;
    @Autowired
    public void setSpellChecker( SpellChecker spellChecker ){
        this.spellChecker = spellChecker;
    }
    public SpellChecker getSpellChecker( ) {
        return spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
