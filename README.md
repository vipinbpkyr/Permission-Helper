# Permission-Helper
Android Fragment Permission Helper Library Using Kotlin Coroutines

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.vipinbpkyr:Permission-Helper:1.0.0'
	}

Usage
 
```Java

var permissionsResult = requestPermissionAsync(arrayOf(Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)).asDeferred().await()

// permissionsResult will contain Permissions Result after User grants the permissions

            permissionsResult.forEach {
                Log.e("Fragment","result $it")
            }
