# AndroidIOC2
------------------------------------------------
这是用android studio做的一个小[Demo](https://github.com/isoot/AndroidIOC)
在用Android studio开发过程中发现了一个问题，Error:Execution failed for task ':app:transformClassesWithDexForDebug'.
> com.android.build.api.transform.TransformException: java.lang.RuntimeException: com.android.ide.common.process.ProcessException: java.util.concurrent.ExecutionException: com.android.ide.common.process.ProcessException: org.gradle.process.internal.ExecException: Process 'command 'C:\Program Files\Java\jdk1.7.0_79\bin\java.exe'' finished with non-zero exit value 1
     
这个问题我上网查过在Stack Overflow上面有详细的介绍这个问题，就是在 

- compileSdkVersion 23
- buildToolsVersion "23.0.0"

这两个要对应一个版本的
