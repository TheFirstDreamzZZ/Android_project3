# 安卓UI组件实验

* 姓名: 龚崇敏</br>

* 学号: 116052017129</br>

* 班级: 数学与信息学院 软件工程3班(大数据方向)</br>

## 实验环境

* Windows10+Android Studio3.5.2

* AS采用安卓10

## 实验1

###     实验要求：利用SimpleAdapter实现以下界面 

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/title1.png" width="500" />

* 实验使用SimpleAdapter函数来实现添加列表Items的效果

关键代码如下</br>
```JAVA
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.list_items,from,to);
        listView.setAdapter(simpleAdapter);
```
其中listItems装入了每个item的配置文件

创建Item点击的监听事件，设置Toast消息提示</br>

代码如下：</br>
```JAVA
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(getApplicationContext(),animalName[i],Toast.LENGTH_LONG).show();
            }

        });
```
###     实验结果截图：

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/test3_1.png" width="375" />

## 实验2

###     实验要求：创建自定义布局的AlertDialog 

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/title2.png" width="500" />

* 实验参考了博客《Android ---------- 弹出层自定义布局 之 AlertDialog》

* 网址：[https://www.cnblogs.com/apeandcat/p/8636818.html](https://www.cnblogs.com/apeandcat/p/8636818.html)

主要有以下几个步骤：</br>

>> 1.创建Alert自定义布局(也就是我们自己弹窗的界面)</br>

>>> 利用了线性布局来处理，分层为：图片、用户名输入框、密码输入框</br>

>> 2.为用户名和密码输入框定义输入类型</br>

>>> 这是一个很有意思的控件，可以设置弹出的输入键盘类型，是英文还是中文</br>

>>> 具体实现为：在EditText中加入android:inputType属性

>> 3.在创建自定义界面时用到的inflater函数来调用没有定义id的自定义界面</br>

```JAVA
LayoutInflater inflater = getLayoutInflater();
```

## 实验结果截图：</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/test3_2.png" width="375" />

## 实验3

###     实验要求：使用xml定义菜单

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/title3.png" width="500" />

* 实验参考了博客《Android 中menu在activity中的使用》</br>

* 网址：[https://www.cnblogs.com/wangjiaghe/p/6683419.html](https://www.cnblogs.com/wangjiaghe/p/6683419.html)

首先要在项目中创建Menu类型资源文件夹</br>

一开始不知道，创建了普通文件夹，走了不少弯路</br>

步骤如下：</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/menu_step1.png" width="375" />

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/menu_step2.png" width="375" />

然后利用item和menu来创建自定义的菜单，子菜单等</br>

最后，在java文件中实现菜单的功能

## 实验结果截图:</br>

主界面：</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/test3_3_surface.png" width="375" />

设置中号字体：</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/font_middle.png" width="375" />

普通菜单项：</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/normal_toast.png" width="375" />

字体颜色:</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/red.png" width="375" />

## 实验4

###     实验要求：创建上下文操作模式(ActionMode)的上下文菜单

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/tree/master/ScreenShoot/title4.png" width="500" />

* 实验参考了官方文档的《创建上下文菜单--使用上下文操作模式》

* 网址：[https://developer.android.google.cn/guide/topics/ui/menus#CAB](https://developer.android.google.cn/guide/topics/ui/menus#CAB)

创建上下文的菜单布局，我这里是设置了一个删除菜单

与SimpleAdapter实验的步骤一样</br>

创建线性布局，和单个Item的布局</br>

利用SelectionAdapter将Items填充进ListView中</br>

接下来就是仿造官方文档的创建代码：</br>

```JAVA
ListView listView = getListView();
listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position,
                                          long id, boolean checked) {
        // Here you can do something when items are selected/de-selected,
        // such as update the title in the CAB
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        // Respond to clicks on the actions in the CAB
        switch (item.getItemId()) {
            case R.id.menu_delete:
                deleteSelectedItems();
                mode.finish(); // Action picked, so close the CAB
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        // Inflate the menu for the CAB
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.context, menu);
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        // Here you can make any necessary updates to the activity when
        // the CAB is removed. By default, selected items are deselected/unchecked.
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        // Here you can perform updates to the CAB due to
        // an <code><a href="/reference/android/view/ActionMode.html#invalidate()">invalidate()</a></code> request
        return false;
    }
});
```

## 实验结果截图:</br>

<img src="https://github.com/TheFirstDreamzZZ/Android_project3/blob/master/ScreenShoot/Screenshot_1587309837.png" width="375" />
