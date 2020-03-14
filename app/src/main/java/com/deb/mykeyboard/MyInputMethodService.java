package com.deb.mykeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Switch;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView kv;
    private Keyboard mKeyboard;

    private  boolean caps = false;
    @Override
    public View onCreateInputView() {
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view,null);
        mKeyboard = new Keyboard(this, R.xml.number_pad);
        kv.setKeyboard(mKeyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;

//        @SuppressLint("InflateParams") KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
//        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
//        keyboardView.setKeyboard(keyboard);
//        keyboardView.setOnKeyboardActionListener(this);
//        return keyboardView;
    }

    private void playClick(int keyCode){
        Context context;
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        switch (keyCode){
            case 32:
                assert am != null;
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case 10:
                assert am != null;
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                assert am != null;
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default:
                assert am != null;
                am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
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
            default:
                char code = (char) primatyCode;
                if(Character.isLetter(code) && caps){
                    code = Character.toUpperCase(code);
                }
                ic.commitText(String.valueOf(code),1);
        }
//        InputConnection inputConnection = getCurrentInputConnection();
//
//        if (inputConnection != null) {
//            switch(primatyCode) {
//                case Keyboard.KEYCODE_DELETE :
//                    CharSequence selectedText = inputConnection.getSelectedText(0);
//
//                    if (TextUtils.isEmpty(selectedText)) {
//                        inputConnection.deleteSurroundingText(1, 0);
//                    } else {
//                        inputConnection.commitText("", 1);
//                    }
//
//                    break;
//                default :
//                    char code = (char) primatyCode;
//                    inputConnection.commitText(String.valueOf(code), 1);
//            }
//        }
    }

    @Override
    public void onText(CharSequence charSequence) {

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
