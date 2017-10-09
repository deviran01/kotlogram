package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsResolveUsername() : TLMethod<TLResolvedPeer>() {
    var username: String = ""

    private val _constructor: String = "contacts.resolveUsername#f93ccba3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(username: String) : this() {
        this.username = username
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLResolvedPeer = tlDeserializer.readTLObject(TLResolvedPeer::class, TLResolvedPeer.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(username)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        username = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(username)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsResolveUsername) return false
        if (other === this) return true

        return username == other.username
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf93ccba3.toInt()
    }
}