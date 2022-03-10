package org.byby.jna;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallLibrary;

public class WindowsUserAdmin {
    public interface Shell32 extends StdCallLibrary {
        boolean IsUserAnAdmin() throws LastErrorException;
    }

    public static final Shell32 INSTANCE =
            Platform.isWindows() ?
                    (Shell32) Native.load("shell32", Shell32.class) : null;

    public static boolean isUserWindowsAdmin() {
        return INSTANCE != null && INSTANCE.IsUserAnAdmin();
    }
}
