package com.corevalue.mymodule

import android.app.Activity
import android.content.Intent

fun startMyModule(context: Activity,  packageName:String){
    val intent = Intent()
    intent.setClassName(packageName,"com.corevalue.mymodule.MyModuleActivity")
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    context.startActivity(intent)
}