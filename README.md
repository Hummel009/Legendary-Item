Hello everybody!

I am the developer of different mods for Minecraft, including this one, and I have posted the latest source code here. I hope, that somebody can find this useful as a basis for your own mods.

<h2> Disclaimer </h2>

These sources are not perfect. They contain a lot of repetitive code, so you might see it and think "WTF, Hummel is a crappy coder".

I aimed to create as simple mods as possible with very simple and easy to modify code. 
In general, I succeeded - some of my friends, who are not programmers and do not know Java, are quietly modifying this code for their needs.

In addition, I try to observe the similarity of the codes in the folders so that the "evolution" in the code is visible in each new version of minecraft. 
To make it clear what was replaced by what, and so on.

<h2> Important info </h2>

All the projects can be opened via Eclipse or Intellij IDEA, but 1.12.2 source can't be launched directly from Intellij IDEA. So I recommend to use Eclipse.

Projects are already configured, using needed JDK version and compiler:

* 1.17.1 is using JDK16
* 1.18.2 and higher are using JDK-16
* All the others are using JDK-8 (JDK 1.8)

Compiler versions are the same as JDK.

If you have problems when importing projects, check your JDK's paths.

<h2> Forges folder </h2>

Everybody know, that old Minecraft versions are dying slowly, because their imported files are disappearing from the Internet. 
There is also a problem in new versions: they are using different gradles, and they are to be downloaded and spam a lot.

So I using my own patched versions of Forge. Old versions are fixed and alive, new versions are not spamming. Success!