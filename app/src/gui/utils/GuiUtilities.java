package gui.utils;

import exceptions.BirdsStoreException;

import javax.swing.*;

public final class GuiUtilities {

    private GuiUtilities() {
    }

    public static void printErrorMessage(Exception ex) {
        JOptionPane.showMessageDialog(null,
                StringConstants.SORRY + ex.getMessage(),
                StringConstants.UNKNOWN_ERROR,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void printErrorMessage(BirdsStoreException ex) {
        JOptionPane.showMessageDialog(null,
                ex.getMessage(),
                StringConstants.BIRDS_STORE_EXCEPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
}
