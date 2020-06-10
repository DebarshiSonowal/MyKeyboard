package com.deb.mykeyboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView kv;
    private Keyboard mKeyboard;
    public static final int main1=0x7f030004;

    public static final int ko1= 0xf0001;
    public static final int ko2= 0xf0002;
    public static final int ko3= 0xf0003;
    public static final int ko4= 0xf0004;
    public static final int ko5= 0xf0005;
    public static final int ko6= 0xf0006;
    public static final int ko7= 0xf0007;
    public static final int ko8= 0xf0008;
    public static final int ko9= 0xf0009;
    public static  final int ko10 = 0xf0010;

    public static  final int kho1 = 0xf1001;
    public static final int kho2 = 0xf1002;

    public static final int go1 = 0xf2001;
    public static final int go2 = 0xf2002;
    public static final int go3 = 0xf2003;
    public static final int go4 = 0xf2004;
    public static final int go5= 0xf2005;
    public static final int go6= 0xf2006;
    public static final int go7=0xf2007;

    public static final int gha1=0xf3001;
    public static final int gha2=0xf3002;
    public static final int gha3=0xf3003;

    public static final int cha1=0xf4001;
    public static final int cha2=0xf4002;
    public static final int cha3=0xf4003;
    public static final int cha4=0xf4004;
    public static final int cha5=0xf4005;

    public static final int ta1 = 0xf5001;
    public static final int ta2 = 0xf5002;
    public static final int ta3 = 0xf5003;
    public static final int ta4=0xf5004;
    public static final int ta5 = 0xf5005;
    public static final int ta6 = 0xf5006;
    public static final int ta7 = 0xf5007;

    public static final int ja1 = 0xf6001;
    public static final int ja2 = 0xf6002;
    public static final int ja3 = 0xf6003;
    public static final int ja4 = 0xf6004;
    public static final int ja5 = 0xf6005;
    public static final int ja6 = 0xf6006;

    public static final int mudda1 = 0xf7001;
    public static final int mudda2 = 0xf7002;
    public static final int mudda3 = 0xf7003;
    public static final int mudda4 = 0xf7004;

    public static final int mudata1 = 0xf8001;
    public static final int mudata2 = 0xf8002;
    public static final int mudata3 = 0xf8003;
    public static final int mudata4 = 0xf8004;

    public static final int unga1 = 0xf9001;
    public static final int unga2 = 0xf9002;

    public static final int nyo1 = 0xfa001;
    public static final int nyo2 = 0xfa002;
    public static final int nyo3 = 0xfa003;

    public static final int ba1 = 0xfb001;
    public static final int ba2 = 0xfb002;
    public static final int ba3 = 0xfb003;
    public static final int ba4 = 0xfb004;
    public static final int ba5 = 0xfb005;
    public static final int ba6 = 0xfb006;
    public static final int ba7 = 0xfb007;

    public static final int bha1 = 0xfc001;
    public static final int bha2 = 0xfc002;

    public static final int da1 = 0xfd001;
    public static final int da2 = 0xfd002;
    public static final int da3 = 0xfd003;
    public static final int da4 = 0xfd004;
    public static final int da5 = 0xfd005;
    public static final int da6 = 0xfd006;
    public static final int da7= 0xfd007;

    public static final int dha1= 0xfe001;
    public static final int dha2 = 0xfe002;
    public static final int dha3 = 0xfe003;
    public static final int dha4 = 0xfe004;

    public static final int na1 = 0xff001;
    public static final int na2 = 0xff002;
    public static final int na3 = 0xff003;
    public static final int na4 = 0xff004;
    public static final int na5 = 0xff005;
    public static final int na6 = 0xff006;
    public static final int na7 = 0xff007;
    public static final int na8 = 0xff008;
    public static final int na9 = 0xff009;
    public static final int na10 = 0xff010;
    public static final int na11 = 0xff011;
    public static final int na12 = 0xff012;
    public static final int na13 = 0xff013;

    public static final int dho1 = 0xffa01;
    public static final int dho2 = 0xffa02;
    public static final int dho3 = 0xffa03;
    public static final int dho4 = 0xffa04;
    public static final int dho5 = 0xffa05;
    public static final int dho6 = 0xffa06;
    public static final int dho7 = 0xffa07;
    public static final int dho8 = 0xffa08;
    public static final int dho9 = 0xffa09;
    public static final int dho10 = 0xffa10;
    public static final int dho11 = 0xffa11;
    public static final int dho12 = 0xffa12;

    public static final int la1 = 0xffb01;
    public static final int la2 = 0xffb02;
    public static final int la3 = 0xffb03;
    public static final int la4 = 0xffb04;
    public static final int la5= 0xffb05;
    public static final int la6 = 0xffb06;
    public static final int la7 = 0xffb07;
    public static final int la8 = 0xffb08;

    public static final int ma1 = 0xffc01;
    public static final int ma2 = 0xffc02;
    public static final int ma3 = 0xffc03;
    public static final int ma4 = 0xffc04;
    public static final int ma5 = 0xffc05;
    public static final int ma6 = 0xffc06;
    public static final int ma7 = 0xffc07;
    public static final int ma8 = 0xffc08;
    public static final int ma9 = 0xffc09;

    public static final int mdhakha1 = 0xffd01;
    public static final int mdhakha2 = 0xffd02;
    public static final int mdhakha3 = 0xffd03;
    public static final int mdhakha4 = 0xffd04;
    public static final int mdhakha5 = 0xffd05;
    public static final int mdhakha6 = 0xffd06;
    public static final int mdhakha7 = 0xffd07;
    public static final int mdhakha8 = 0xffd08;

    public static final int pa1 = 0xffe01;
    public static final int pa2 = 0xffe02;
    public static final int pa3 = 0xffe03;
    public static final int pa4 = 0xffe04;
    public static final int pa5 = 0xffe05;
    public static final int pa6 = 0xffe06;

    public static final int talbiya1 = 0xfff01;
    public static final int talbiya2= 0xfff02;
    public static final int talbiya3= 0xfff03;
    public static final int talbiya4= 0xfff04;
    public static final int talbiya5= 0xfff05;
    public static final int talbiya6= 0xfff06;
    public static final int talbiya7= 0xfff07;
    public static final int talbiya8= 0xfff08;
    public static final int talbiya9= 0xfff09;

    public static final int jyakar= 0xfaaaa001;
    public static final int khyajya= 0xfafafafa;

    private Boolean volume;
    private  boolean caps = false;



    @Override
    public View onCreateInputView() {
        loadData();
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view,null);
        mKeyboard = new Keyboard(this, R.xml.number_pad);
        kv.setKeyboard(mKeyboard);
        kv.setOnKeyboardActionListener(this);
        FontOverride.setDefaultFont(this, "DEFAULT", "Fonts/regular.ttf");
        return kv;

    }

    private void loadData() {
        SharedPreferences preferences =getSharedPreferences("prefs", Context.MODE_PRIVATE);
        volume = preferences.getBoolean("switch",true);
    }

    private void playClick(int keyCode){
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        switch (keyCode){
            case 32:
                assert am != null;
                if (volume) {
                    am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                }
                break;
            case 10:
                assert am != null;
                if (volume) {
                    am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                }
                break;
            case Keyboard.KEYCODE_DELETE:
                assert am != null;
                if (volume) {
                    am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                }
                break;
            default:
                assert am != null;
                if (volume) {
                    am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
                }
        }
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case 0x0995:
                kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view,null);
                mKeyboard = new Keyboard(this, R.xml.ko);
                kv.setKeyboard(mKeyboard);
                kv.setOnKeyboardActionListener(this);
                FontOverride.setDefaultFont(this, "DEFAULT", "Fonts/regular.ttf");
                break;
        }

        return true;

}


    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("destroy","ondestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onKey(int primatyCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
            playClick(primatyCode);
//           s
            switch(primatyCode){
                case 0xfffff9:
                    InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                    imeManager.showInputMethodPicker();
                    break;
                case Keyboard.KEYCODE_DELETE:
                    ic.deleteSurroundingText(1,0);
                    break;
                    case Keyboard.KEYCODE_SHIFT:
                        caps = !caps;
                        mKeyboard.setShifted(caps);
                        kv.invalidateAllKeys();
                        break;
                        case Keyboard.KEYCODE_DONE:
                            ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_ENTER));
                            break;
                case main1:
                        ic.commitText("ক্ষ",1);
                    break;
                    case ko1:
                        ic.commitText("ক্ব",1);
                        break;
                case ko2:
                    ic.commitText("ক্ক",1);
                    break;
                case ko3:
                    ic.commitText("ক্ট",1);
                    break;
                case ko4:
                    ic.commitText("ক্ন",1);
                    break;
                case ko5:
                    ic.commitText("ক্ম",1);
                    break;
                case ko6:
                    ic.commitText("ক্ল",1);
                    break;
                case ko7:
                    ic.commitText("ক্স",1);
                    break;
                case ko8:
                    ic.commitText("ক্র",1);
                    break;
                case ko9:
                    ic.commitText("ঙ্ক",1);
                    break;
                case ko10:
                    ic.commitText("ক্ত",1);
                    break;
                case kho1:
                    ic.commitText("খ্ব",1);
                    break;
                case kho2:
                    ic.commitText("খ্র",1);
                    break;
                case go1:
                    ic.commitText("গু",1);
                    break;
                case go2:
                    ic.commitText("গ্গ",1);
                    break;
                case go3:
                    ic.commitText("গ্র",1);
                    break;
                case go4:
                    ic.commitText("গ্ধ",1);
                    break;
                case go5:
                    ic.commitText("গ্ন",1);
                    break;
                case go6:
                    ic.commitText("গ্ম",1);
                    break;
                case go7:
                    ic.commitText("গ্ল",1);
                    break;
                case 0xf2008:
                    ic.commitText("গ্দ",1);
                    break;
                case gha1:
                    ic.commitText("ঘ্ব",1);
                    break;
                case gha2:
                    ic.commitText("ঘ্ৰ",1);
                    break;
                case gha3:
                    ic.commitText("ঘ্ন",1);
                    break;
                case cha1:
                    ic.commitText("চ্চ",1);
                    break;
                case cha2:
                    ic.commitText("চ্ছ",1);
                    break;
                case cha3:
                    ic.commitText("চ্ব",1);
                    break;
                case cha4:
                    ic.commitText("চ্ন",1);
                    break;
                case cha5:
                    ic.commitText("চ্র",1);
                    break;
                case ta1:
                    ic.commitText("ত্ত",1);
                    break;
                case ta2:
                    ic.commitText("ত্থ",1);
                    break;
                case ta3:
                    ic.commitText("ত্ন",1);
                    break;
                case ta4:
                    ic.commitText("ত্ম",1);
                    break;
                case ta5:
                    ic.commitText("ত্ল",1);
                    break;
                case ta6:
                    ic.commitText("ত্র",1);
                    break;
                case ta7:
                    ic.commitText("ত্ব",1);
                    break;
                case ja1:
                    ic.commitText("জ্জ",1);
                    break;
                case ja2:
                    ic.commitText("জ্ঝ",1);
                    break;
                case ja3:
                    ic.commitText("জ্ঞ",1);
                    break;
                case ja4:
                    ic.commitText("জ্ব",1);
                    break;
                case ja5:
                    ic.commitText("জ্র",1);
                    break;
                case ja6:
                    ic.commitText("জ্জ্ব",1);
                    break;
                case mudda1:
                    ic.commitText("ড্ড",1);
                    break;
                case mudda2:
                    ic.commitText("ড্ম",1);
                    break;
                case mudda3:
                    ic.commitText("ড্ব",1);
                    break;
                case mudda4:
                    ic.commitText("ড্র",1);
                    break;
                case mudata1:
                    ic.commitText("ট্ট",1);
                    break;
                case mudata2:
                    ic.commitText("ট্ম",1);
                    break;
                case mudata3:
                    ic.commitText("ট্র",1);
                    break;
                case mudata4:
                    ic.commitText("ট্ব",1);
                    break;
                case unga1:
                    ic.commitText("ঙ্ক",1);
                    break;
                case unga2:
                    ic.commitText("ঙ্গ",1);
                    break;
                case nyo1:
                    ic.commitText("ঞ্ছ",1);
                    break;
                case nyo2:
                    ic.commitText("ঞ্জ",1);
                    break;
                case nyo3:
                    ic.commitText("ঞ্চ",1);
                    break;
                case ba1:
                    ic.commitText("ব্জ",1);
                    break;
                case ba2:
                    ic.commitText("ব্ড",1);
                    break;
                case ba3:
                    ic.commitText("ব্ঢ",1);
                    break;
                case ba4:
                    ic.commitText("ব্দ",1);
                    break;
                case ba5:
                    ic.commitText("ব্ধ",1);
                    break;
                case ba6:
                    ic.commitText("ব্ব",1);
                    break;
                case ba7:
                    ic.commitText("ব্র",1);
                    break;
                case bha1:
                    ic.commitText("ভ্ল",1);
                    break;
                case bha2:
                    ic.commitText("ভ্র",1);
                    break;
                case da1:
                    ic.commitText("দ্দ",1);
                    break;
                case da2:
                    ic.commitText("দ্ব",1);
                    break;
                case da3:
                    ic.commitText("দ্ধ",1);
                    break;
                case da4:
                    ic.commitText("দ্ধ্ব",1);
                    break;
                case da5:
                    ic.commitText("দ্ন",1);
                    break;
                case da6:
                    ic.commitText("দ্ম",1);
                    break;
                case da7:
                    ic.commitText("দ্ৰ",1);
                    break;
                case dha1:
                    ic.commitText("ধ্ব",1);
                    break;
                case dha2:
                    ic.commitText("ধ্ন",1);
                    break;
                case dha3:
                    ic.commitText("ধ্ম",1);
                    break;
                case dha4:
                    ic.commitText("ধ্র",1);
                    break;
                case na1:
                    ic.commitText("ন্ব",1);
                    break;
                case na2:
                    ic.commitText("ন্ট",1);
                    break;
                case na3:
                    ic.commitText("ন্ঠ",1);
                    break;
                case na4:
                    ic.commitText("ন্ড",1);
                    break;
                case na5:
                    ic.commitText("ন্ত",1);
                    break;
                case na6:
                    ic.commitText("ন্তু",1);
                    break;
                case na7:
                    ic.commitText("ন্হ",1);
                    break;
                case na8:
                    ic.commitText("ন্দ",1);
                    break;
                case na9:
                    ic.commitText("ন্দ্র",1);
                    break;
                case na10:
                    ic.commitText("ন্ধ",1);
                    break;
                case na11:
                    ic.commitText("ন্ন",1);
                    break;
                case na12:
                    ic.commitText("ন্ম",1);
                    break;
                case na13:
                    ic.commitText("ন্ৰ",1);
                    break;
                case dho1:
                    ic.commitText("স্ৰ",1);
                    break;
                case dho2:
                    ic.commitText("স্ক",1);
                    break;
                case dho3:
                    ic.commitText("স্ক্র",1);
                    break;
                case dho4:
                    ic.commitText("স্খ",1);
                    break;
                case dho5:
                    ic.commitText("স্ত",1);
                    break;
                case dho6:
                    ic.commitText("স্ত্র",1);
                    break;
                case dho7:
                    ic.commitText("স্থ",1);
                    break;
                case dho8:
                    ic.commitText("স্ন",1);
                    break;
                case dho9:
                    ic.commitText("স্প",1);
                    break;
                case dho10:
                    ic.commitText("স্ফ",1);
                    break;
                case dho11:
                    ic.commitText("স্ম",1);
                    break;
                case dho12:
                    ic.commitText("স্ল",1);
                    break;
                case la1:
                    ic.commitText("ল্ব",1);
                    break;
                case la2:
                    ic.commitText("ল্ক",1);
                    break;
                case la3:
                    ic.commitText("ল্ট",1);
                    break;
                case la4:
                    ic.commitText("ল্ড",1);
                    break;
                case la5:
                    ic.commitText("ল্দ",1);
                    break;
                case la6:
                    ic.commitText("ল্প",1);
                    break;
                case la7:
                    ic.commitText("ল্ম",1);
                    break;
                case la8:
                    ic.commitText("ল্ল",1);
                    break;
                case ma1:
                    ic.commitText("ম্ব",1);
                    break;
                case ma2:
                    ic.commitText("ম্ত",1);
                    break;
                case ma3:
                    ic.commitText("ম্দ",1);
                    break;
                case ma4:
                    ic.commitText("ম্ন",1);
                    break;
                case ma5:
                    ic.commitText("ম্প",1);
                    break;
                case ma6:
                    ic.commitText("ম্ফ",1);
                    break;
                case ma7:
                    ic.commitText("ম্ভ",1);
                    break;
                case ma8:
                    ic.commitText("ম্ম",1);
                    break;
                case ma9:
                    ic.commitText("ম্ল",1);
                    break;
                case mdhakha1:
                    ic.commitText("ষ্ব",1);
                    break;
                case mdhakha2:
                    ic.commitText("ষ্ক",1);
                    break;
                case mdhakha3:
                    ic.commitText("ষ্ক্র",1);
                    break;
                case mdhakha4:
                    ic.commitText("ষ্ট",1);
                    break;
                case mdhakha5:
                    ic.commitText("ষ্ঠ",1);
                    break;
                case mdhakha6:
                    ic.commitText("ষ্ণ",1);
                    break;
                case mdhakha7:
                    ic.commitText("ষ্প",1);
                    break;
                case mdhakha8:
                    ic.commitText("ষ্ম",1);
                    break;
                case pa1:
                    ic.commitText("প্ট",1);
                    break;
                case pa2:
                    ic.commitText("প্ত",1);
                    break;
                case pa3:
                    ic.commitText("প্ন",1);
                    break;
                case pa4:
                    ic.commitText("প্প",1);
                    break;
                case pa5:
                    ic.commitText("প্ল",1);
                    break;
                case pa6:
                    ic.commitText("প্র",1);
                    break;
                case talbiya1:
                    ic.commitText("শু",1);
                    break;
                case talbiya2:
                    ic.commitText("শ্চ",1);
                    break;
                case talbiya3:
                    ic.commitText("শ্ছ",1);
                    break;
                case talbiya4:
                    ic.commitText("শ্ত",1);
                    break;
                case talbiya5:
                    ic.commitText("শ্ম",1);
                    break;
                case talbiya6:
                    ic.commitText("শ্ন",1);
                    break;
                case talbiya7:
                    ic.commitText("শ্ল",1);
                    break;
                case talbiya8:
                    ic.commitText("শ্ব",1);
                    break;
                case talbiya9:
                    ic.commitText("শ্র",1);
                    break;
                case jyakar:
                    ic.commitText("্য",1);
                    break;
                case khyajya:
                    ic.commitText("খ্য",1);
                    break;
                case 0xfffffff:
                    break;
                default:
                    char code = (char) primatyCode;
                    if(Character.isLetter(code) && caps){
                        code = Character.toUpperCase(code);
                    }
                    ic.commitText(String.valueOf(code),1);
            }
        }

//    private void check(int primatyCode) {
//        if(String.valueOf(primatyCode) == "0x0995,0x09CD,0x09B7")
//        {
//            InputConnection ic = getCurrentInputConnection();
//            ic.commitText("ক্ষ",0);
//        }
//    }


    @Override
    public void onText(CharSequence charSequence) {
        InputConnection ic = getCurrentInputConnection();
        ic.commitText(charSequence,0);


    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }


}
