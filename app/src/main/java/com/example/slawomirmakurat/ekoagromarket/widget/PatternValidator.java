//package com.example.slawomirmakurat.ekoagromarket.widget;
//
//import android.widget.EditText;
//
//import java.util.regex.Pattern;
//
///**
// * Created by slawomir.makurat on 2017-03-23.
// */
//
//public class PatternValidator extends Validator {
//        private Pattern pattern;
//
//    public PatternValidator(String _customErrorMessage, Pattern _pattern) {
//            super(_customErrorMessage);
//            if (_pattern == null) throw new IllegalArgumentException("_pattern must not be null");
//            pattern = _pattern;
//        }
//
//    public boolean isValid(EditText et) {
//        return pattern.matcher(et.getText()).matches();
//    }
//
//}
