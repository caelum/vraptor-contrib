Place your VRaptor contributions here.
Forks are welcome.

How to contribute
=================

- Create a repository for your plugin: e.g http://github.com/your_user/your_plugin
- Implement your VRaptor plugin, recipe or tip
- write some docs (english or portuguese)
- Fork and clone this repo:

```
git clone git@github.com:your_user/vraptor-contrib.git
cd vraptor-contrib
```

- create a branch based on the main repo:

```
git remote add main git://github.com/caelum/vraptor-contrib.git #if not done
git checkout -b your_plugin main/master
```

- add your submodule

```
git submodule add http://github.com/your_user/your_plugin
git commit -am "adding my super cool plugin =)"
git push origin your_plugin
```

- send us a pull request for this your\_plugin branch

Thanks

