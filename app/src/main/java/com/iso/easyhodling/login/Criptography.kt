import javax.crypto.ShortBufferException
import java.security.NoSuchAlgorithmException
import javax.crypto.NoSuchPaddingException
import javax.crypto.BadPaddingException
import javax.crypto.IllegalBlockSizeException
import java.io.UnsupportedEncodingException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.util.encoders.Base64
import java.security.InvalidKeyException
import java.security.Security
import javax.crypto.SecretKey

import javax.crypto.KeyGenerator


class Criptography {
    private val SECRET_KEY = generateKey(256).toString()

    fun generateKey(numBits: Int): SecretKey? {
        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(numBits)
        return keyGenerator.generateKey()
    }

    fun encrypt(strToEncrypt: String): String {
        Security.addProvider(BouncyCastleProvider())
        var keyBytes: ByteArray

        keyBytes = SECRET_KEY.toByteArray(charset("UTF8"))
        val skey = SecretKeySpec(keyBytes, "AES")
        val input = strToEncrypt.toByteArray(charset("UTF8"))

        synchronized(Cipher::class.java) {
            val cipher = Cipher.getInstance("AES/ECB/PKCS7Padding")
            cipher.init(Cipher.ENCRYPT_MODE, skey)

            val cipherText = ByteArray(cipher.getOutputSize(input.size))
            var ctLength = cipher.update(
                input, 0, input.size,
                cipherText, 0
            )
            ctLength += cipher.doFinal(cipherText, ctLength)
            return String(
                Base64.encode(cipherText)
            )
        }
    }

        fun decryptWithAES(strToDecrypt: String?): String {
            Security.addProvider(BouncyCastleProvider())
            var keyBytes: ByteArray

            keyBytes = SECRET_KEY.toByteArray(charset("UTF8"))
            val skey = SecretKeySpec(keyBytes, "AES")
            val input = org.bouncycastle.util.encoders.Base64
                .decode(strToDecrypt?.trim { it <= ' ' }?.toByteArray(charset("UTF8")))

            synchronized(Cipher::class.java) {
                val cipher = Cipher.getInstance("AES/ECB/PKCS7Padding")
                cipher.init(Cipher.DECRYPT_MODE, skey)

                val plainText = ByteArray(cipher.getOutputSize(input.size))
                var ptLength = cipher.update(input, 0, input.size, plainText, 0)
                ptLength += cipher.doFinal(plainText, ptLength)
                val decryptedString = String(plainText)
                return decryptedString.trim { it <= ' ' }

            }
        }
    }