package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileMp3 extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0x528a0677;

    public TLFileMp3() {
    }

    @Override
    public String toString() {
        return "storage.fileMp3#528a0677";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
