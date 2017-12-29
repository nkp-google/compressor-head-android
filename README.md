# Compressor Head Android
![Codacy Badge](https://api.codacy.com/project/badge/Grade/e904554ecb774f9188d4458c2b277fc5)
[![Build Status](https://travis-ci.org/jboss-outreach/compressor-head-android.svg?branch=master)](https://travis-ci.org/jboss-outreach/compressor-head-android)
[![Gitter chat](https://badges.gitter.im/gitterHQ/services.png)](https://gitter.im/jboss-outreach)

## Contents
* [What is compressor-head-android?](#cha)
* [What is Compressor Head?](#ch)
* [Setting up the Project](#setup)
* [Running the App](#run)
* [Contributing](#contributing)
* [Additional Learning](#learning)

## <a id = "cha"> </a> What is compressor-head-android?

*Compressor Head on Android* is an Android client that generates image URLs for the [Compressor Head](https://github.com/jboss-outreach/compressor-head) web application.
It takes various specifications of an image such as its **URL or source**, **width**, **height**, and **format** (PNG, JPEG or WEBP) as arguments to generate a usable image URL in accordance with the dimensions and format specified.

## <a id = "ch"> </a> What is Compressor Head?

Compressor Head is a fast web application based on [Python](https://www.python.org/) to resize images.
For a more detailed explanation, visit the [Compressor Head](https://github.com/jboss-outreach/compressor-head)
project. You can use this to compress images for websites which have a maximum capping for uploading an image or use it to scale up the images.

## <a id = "setup"> </a> Setting up the Project

### Code Setup
**If you want to just download the app**

- Just download [.zip](https://github.com/jboss-outreach/compressor-head-android/archive/master.zip) file.

**If you want to contribute to the project**

1. **Fork** ![](https://camo.githubusercontent.com/ba881041f4d7c96895e8466eece0c43317919f56/68747470733a2f2f696d6167652e6962622e636f2f667953745a6d2f666f726b2e706e67) the repository by clicking on the Fork icon at the top right corner of this page.
2. **Clone** the repository on to your local machine by running the following commands on git:
```
$ git clone https://github.com/[YOUR-USERNAME]/compressor-head-android.git
```

3. If you need help, refer [Forking and Cloning in git](https://help.github.com/articles/fork-a-repo/). You can also ask for help on the [chat](https://gitter.im/jboss-outreach/gci).

### IDE Setup
##### It is recommanded to use Android Studio:
1. Download and install [Android Studio](https://developer.android.com/studio/index.html).
2. You will also need to download the Android SDK from the IDE itself.
3. Import the **cloned** repository into Android Studio by clicking on `files --> Open` and navigate to the directory where you forked the repository.

##### You can also choose other preferred IDEs:
- The [Elipse IDE](https://eclipse.org/) and its [setup guide](http://www.instructables.com/id/How-To-Setup-Eclipse-for-Android-App-Development/).
- The [IntelliJ IDEA](https://www.jetbrains.com/idea/) and its [setup guide](https://www.jetbrains.com/help/idea/importing-an-existing-android-project.html).

## <a id = "run"> </a> Running the Application
***Via your own android smartphone.***

- Enable [USB Debugging](https://www.howtogeek.com/129728/how-to-access-the-developer-options-menu-and-enable-usb-debugging-on-android-4.2/) on your phone.
- Click **Run** on the Android Studio tool bar, or **Shift + F10** and then choose your phone to [run the app](https://developer.android.com/studio/run/device.html).

***By running a virtual device.***
 - Setup a [Android Virtual Device](https://developer.android.com/studio/run/managing-avds.html) in the IDE.
 - Click **Run** on the Android Studio tool bar, or **Shift + F10** and then choose the newly created virtual device to [run the app](https://developer.android.com/studio/run/device.html).

## <a id = "contributing"> </a> Contributing to the project


**Step 1: Fork this project:**

Go to the top right of the project page and click on "Fork". A fork of this repo will be created on your GitHub account.

**Step 2: Code your changes**:

Create a new branch by:
```
git checkout -b YOUR_NEW_BRANCH_NAME
```
Then create/edit files as per your coding requirements. Ensure that your code is clean and efficient, and avoid redundancies. It is also advised to follow naming conventions as and where specified. Also make sure that your code is your own, and is not closed-source or stolen.

**Step 3: Commiting and pushing the changes:**

*Commit* the changes and *push* the commit to your forked repository on GitHub by:
```
# for including inidividual files
git add filename.extension
# for including all files at once
git add .
```
```
git commit -m"Your commit message here"
git push origin
```
If stuck at this point, refer [here](https://readwrite.com/2013/10/02/github-for-beginners-part-2/)

**Step 4: Sending a Pull Request (PR):**

Once you are done coding the changes, commit the files and create a [*PR*](https://help.github.com/articles/about-pull-requests/). Click on "Compare across forks" when creating the PR, and select the master branch of this repo as the base. Set the head to your branch on your fork. Click on the button "Create Pull Request". Give your PR a meaningful title and a brief message explaining the purpose of your commits.

**Step 5: Ensuring code quality**

Once a PR has been created, check if it can be merged without any issues or conflicts. If there are any issues, repeat from **Step 2** and try to resolve them. Wait for a reviewer to cross check your changes, and then merge your changes.

* Additional Reference regarding clone, fork and editing a repository [**here**](https://egghead.io/lessons/javascript-how-to-fork-and-clone-a-github-repository).

```
Keep Contributing to open source! =)
```

## <a id = "learning"> </a> Additional Learning

* [More about Android Studio](https://developer.android.com/studio/intro/index.html)
* [Buiding your first App](https://developer.android.com/training/basics/firstapp/index.html)
* [Guide to Material design](https://material.io/)
* [Guide to Virtual Emulators](https://developer.android.com/studio/run/emulator.html)
* [How to use GitHub](https://guides.github.com/activities/hello-world/)
* [Git commands handbook](https://git-scm.com/docs)
* [Chat with us!](https://gitter.im/jboss-outreach)
