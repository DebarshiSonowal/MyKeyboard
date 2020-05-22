package com.deb.mykeyboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

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



private Boolean volume;
    private  boolean caps = false;
    @Override
    public View onCreateInputView() {
        loadData();
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view,null);
        mKeyboard = new Keyboard(this, R.xml.number_pad);
        kv.setKeyboard(mKeyboard);
        kv.setOnKeyboardActionListener(this);
        kv.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });
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
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primatyCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();

            playClick(primatyCode);
//           s
            switch(primatyCode){
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
