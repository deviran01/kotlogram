package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactSuggested extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x3de191a1;

    protected int userId;

    protected int mutualContacts;

    public TLContactSuggested() {
    }

    public TLContactSuggested(int userId, int mutualContacts) {
        this.userId = userId;
        this.mutualContacts = mutualContacts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeInt(mutualContacts, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        mutualContacts = readInt(stream);
    }

    @Override
    public String toString() {
        return "contactSuggested#3de191a1";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMutualContacts() {
        return mutualContacts;
    }

    public void setMutualContacts(int mutualContacts) {
        this.mutualContacts = mutualContacts;
    }
}
