package org.byby.jna;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.WinBase.SYSTEMTIME;

public class WindowSetDateTime {

    /**
     * Kernel32 DLL Interface. kernel32.dll uses the __stdcall calling
     * convention (check the function declaration for "WINAPI" or "PASCAL"), so
     * extend StdCallLibrary Most C libraries will just extend
     * com.sun.jna.Library,
     */
    public interface Kernel32 extends StdCallLibrary {
        boolean SetLocalTime(SYSTEMTIME st);
        Kernel32 instance = Native.load("kernel32.dll", Kernel32.class);
    }

    public boolean SetLocalTime(SYSTEMTIME st) {
        return Kernel32.instance.SetLocalTime(st);
    }

    public boolean SetLocalTime(short wYear,
                                short wMonth,
                                short wDay,
                                short wHour,
                                short wMinute,
                                short wSecond) {
        SYSTEMTIME st = new SYSTEMTIME();

        st.wYear = wYear;
        st.wMonth = wMonth;
        st.wDay = wDay;
        st.wHour = wHour;
        st.wMinute = wMinute;
        st.wSecond = wSecond;
        return SetLocalTime(st);
    }
}
