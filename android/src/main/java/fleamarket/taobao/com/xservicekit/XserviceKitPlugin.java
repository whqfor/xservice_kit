package fleamarket.taobao.com.xservicekit;

import androidx.annotation.NonNull;

import fleamarket.taobao.com.xservicekit.message.MessengerFacade;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/**
 * XserviceKitPlugin
 */
public class XserviceKitPlugin implements FlutterPlugin, MethodCallHandler {
    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        final MethodChannel channel = new MethodChannel(binding.getBinaryMessenger(), "xservice_kit");
        channel.setMethodCallHandler(this);

        //Connect to messenger.
        MessengerFacade.sharedInstance().setMessenger(binding.getBinaryMessenger());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {

    }
}
