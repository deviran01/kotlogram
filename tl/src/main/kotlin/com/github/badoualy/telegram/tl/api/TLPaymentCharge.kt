package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * paymentCharge#ea02c27e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentCharge() : TLObject() {
    var id: String = ""

    var providerChargeId: String = ""

    private val _constructor: String = "paymentCharge#ea02c27e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: String, providerChargeId: String) : this() {
        this.id = id
        this.providerChargeId = providerChargeId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(id)
        writeString(providerChargeId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readString()
        providerChargeId = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(id)
        size += computeTLStringSerializedSize(providerChargeId)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentCharge) return false
        if (other === this) return true

        return id == other.id
                && providerChargeId == other.providerChargeId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xea02c27e.toInt()
    }
}