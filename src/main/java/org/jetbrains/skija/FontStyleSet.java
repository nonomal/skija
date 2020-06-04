package org.jetbrains.skija;

public class FontStyleSet extends RefCounted {
    public static FontStyleSet createEmpty() {
        Native.onNativeCall();
        return new FontStyleSet(nCreateEmpty());
    }

    public int count() {
        Native.onNativeCall();
        return nCount(nativeInstance);
    }

    public FontStyle getStyle(int index) {
        Native.onNativeCall();
        return new FontStyle(nGetStyle(nativeInstance, index));
    }    

    public String getStyleName(int index) {
        Native.onNativeCall();
        return nGetStyleName(nativeInstance, index);
    }        

    public SkTypeface createTypeface(int index) {
        Native.onNativeCall();
        return new SkTypeface(nCreateTypeface(nativeInstance, index));
    }    

    public SkTypeface matchStyle(FontStyle style) {
        Native.onNativeCall();
        return new SkTypeface(nMatchStyle(nativeInstance, style.value));
    }    

    protected FontStyleSet(long nativeInstance) { super(nativeInstance); }
    private static native long nCreateEmpty();
    private static native int nCount(long ptr);
    private static native int nGetStyle(long ptr, int index);
    private static native String nGetStyleName(long ptr, int index);
    private static native long nCreateTypeface(long ptr, int index);
    private static native long nMatchStyle(long ptr, int style);
}