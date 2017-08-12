/**
 * Created by WEI on 12/08/2017.
 */
import com.ajilisiwei.devplatform.helper.ShellHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuShellTest {
    public static void main(String[] args){
        String shpath="/Volumes/Corner0/JavaProjects/EclipseProjects/DevPlatform/src/test/resources/maveninit.sh";
        ShellHelper.ExecShellScriptFile(shpath);
    }
}