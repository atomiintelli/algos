import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.security.KeyPair;
import java.util.Base64;

class DiffieHellmanKeyExchangeTest {

    DiffieHellmanKeyExchange dh = new DiffieHellmanKeyExchange();

    @Test
    void diffieHellmanTest() {
        try {
            // Simulate Alice and Bob's key exchange
            KeyPair aliceKeyPair = dh.generateKeyPair();
            KeyPair bobKeyPair = dh.generateKeyPair();

            // Simulate Alice sending her public key to Bob
            byte[] alicePublicKeyBytes = aliceKeyPair.getPublic().getEncoded();
            // Simulate Bob sending his public key to Alice
            byte[] bobPublicKeyBytes = bobKeyPair.getPublic().getEncoded();

            // Alice receives Bob's public key and computes the shared secret
            byte[] aliceSharedSecret = dh.computeSharedSecret(aliceKeyPair.getPrivate(), bobPublicKeyBytes);

            // Bob receives Alice's public key and computes the shared secret
            byte[] bobSharedSecret = dh.computeSharedSecret(bobKeyPair.getPrivate(), alicePublicKeyBytes);

            // Convert shared secrets to Base64-encoded strings for comparison
            String aliceSharedSecretString = Base64.getEncoder().encodeToString(aliceSharedSecret);
            String bobSharedSecretString = Base64.getEncoder().encodeToString(bobSharedSecret);

            // Assert that the shared secrets computed by Alice and Bob are the same
            assertEquals(aliceSharedSecretString, bobSharedSecretString);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during key exchange.");
        }
    }
}
