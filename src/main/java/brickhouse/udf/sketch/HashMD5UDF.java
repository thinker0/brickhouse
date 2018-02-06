package brickhouse.udf.sketch;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.nio.charset.StandardCharsets;

/**
 * Calculate the MD5 hash for a String.
 * <p/>
 * Useful for sketching ...
 *
 * @author jeromebanks
 */
@Description(name = "hash_md5",
        value = "_FUNC_(x) - Hash MD5. "
)
public class HashMD5UDF extends UDF {
    private HashFunction hash = Hashing.md5();


    public Long evaluate(String str) {
        HashCode hc = hash.hashString(str, StandardCharsets.UTF_8);

        return hc.asLong();
    }
}
