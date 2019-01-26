# speech-demo开发环境
1. 开发IDE：intellij idea、maven
2. 开发语言：java
3. 协议：websocket、grpc

# speech依赖的protobuf文件，这三个文件已放入demo中
1. auth.proto
2. speech_types.proto
3. speech.proto

# 使用protobuf文件生成java类
1. 工程中的pom文件已配置protobuf生成java类插件
2. 在terminal下首先执行mvn protobuf:compile，然后再执行mvn protobuf:compile-custom命令，执行成功后会在target目录下生成对应的java文件

# speech-demo说明
1. 发送文本给speech服务器，得到相应结果，对应方法：testSpeechText
2. 发送语音给speech服务器，得到相应结果，对应方法：testSpeechVoice