package com.rokid.speech.test;

import com.rokid.speech.v2.SpeechVt;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 作者: mashuangwei
 * 日期: 2017/8/22
 */

public class SpeechVTDemo {

    // 以下几个值从rokid开放平台获取或者rokid提供
    String key = "";
    String deviceTypeId = "";
    String version = "2.0";
    String secret = "";
    String deviceId = "";
    String url = "wss://apigwws.open.rokid.com/api";

    /**
     * 直接发送文本（对比直接发送语音数据，服务端少了一个asr识别语音为文字过程）
     */
    @Test
    public void testSpeechText() {
        SpeechVt webSock = null;
        try {
            webSock = new SpeechVt(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        webSock.init(key, deviceTypeId, version, secret, deviceId);
        webSock.sendSpeechText("若琪今天天气怎么样");
        webSock.close();

    }

    /**
     * 发送语音数据
     */
    @Test
    public void testSpeechVoice() {
        SpeechVt webSock = null;
        try {
            webSock = new SpeechVt(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        webSock.init(key, deviceTypeId, version, secret, deviceId);
        String path = System.getProperty("user.dir") + "/src/main/resources/files/car.pcm";
        float voice_power = 100L;

        webSock.sendDataByTime("PCM", "ZH", path, "", voice_power, false, false);
        webSock.close();
    }

}
