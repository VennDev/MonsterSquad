package org.monstersquad.handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right, attack, menu, enter, escape;

    public KeyHandler() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = true;
        }

        if (code == KeyEvent.VK_S) {
            down = true;
        }

        if (code == KeyEvent.VK_A) {
            left = true;
        }

        if (code == KeyEvent.VK_D) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = false;
        }

        if (code == KeyEvent.VK_S) {
            down = false;
        }

        if (code == KeyEvent.VK_A) {
            left = false;
        }

        if (code == KeyEvent.VK_D) {
            right = false;
        }
    }

}
