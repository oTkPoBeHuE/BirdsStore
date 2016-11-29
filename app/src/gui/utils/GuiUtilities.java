package gui.utils;

import exceptions.BirdsStoreException;

import javax.swing.*;

/**
 * Created by oTk on 29.11.2016.
 */
public final class GuiUtilities {

    private GuiUtilities() {
    }

    public static void printErrorMessage(Exception ex) {
        JOptionPane.showMessageDialog(null,
                ex.getMessage(),
                "Unknown error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void printErrorMessage(BirdsStoreException ex) {
        JOptionPane.showMessageDialog(null,
                ex.getMessage(),
                "BirdsStoreException",
                JOptionPane.PLAIN_MESSAGE);
    }
}
