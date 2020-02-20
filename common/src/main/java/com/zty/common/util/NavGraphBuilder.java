package com.zty.common.util;


import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavigatorProvider;


public class NavGraphBuilder {
    public static void build(FragmentActivity activity, NavController controller, int containerId) {
        NavigatorProvider provider = controller.getNavigatorProvider();

        //NavGraphNavigator也是页面路由导航器的一种，只不过他比较特殊。
        //它只为默认的展示页提供导航服务,但真正的跳转还是交给对应的navigator来完成的
        NavGraph navGraph = controller.getGraph();

        //FragmentNavigator fragmentNavigator = provider.getNavigator(FragmentNavigator.class);
        //fragment的导航此处使用我们定制的FixFragmentNavigator，底部Tab切换时 使用hide()/show(),而不是replace()
        FixedFragmentNavigator fragmentNavigator = new FixedFragmentNavigator(activity, activity.getSupportFragmentManager(), containerId);
        provider.addNavigator(fragmentNavigator);

        controller.setGraph(navGraph);
    }
}
