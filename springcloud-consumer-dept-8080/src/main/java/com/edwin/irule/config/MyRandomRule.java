package com.edwin.irule.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description :[修改 源码 ，自定义随机算发规则]
 * @aothor EdwinYu
 * @date 2018年8月29日
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

	private int total =0; //总共被调用的次数，目前要求每台被调用5次
	private int currentIndex=0; //当前提供服务的机器号
	
   public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		  while (server == null) {
			if (Thread.interrupted()) {  //线程是否被中断
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers(); //获取所有的服务

			int serverCount = allList.size();  //获取所有的服务数量
			if (serverCount == 0) {
				return null;
			}
			
			//原始的的随机算发
			//int index = chooseRandomInt(serverCount);  //随机获取服务的交表
	    	//	server = upList.get(index); //取出对应的server

			// 修改后的算发  每次每台机器5次
			if(total < 5) {
			   server =upList.get(currentIndex);
			   total++;
			}else{
			  total =0;
			  currentIndex ++;
			  if(currentIndex >= upList.size()) {
				  currentIndex = 0;
			  }
			}
			
			
			if (server == null) { //服务为空，则等待片刻  继续操作
				Thread.yield();
				continue;
			}
			if (server.isAlive()) {
				return (server);
			}
			server = null;
			Thread.yield();
		}

		return server;

	}

	protected int chooseRandomInt(int serverCount) {
		return ThreadLocalRandom.current().nextInt(serverCount);
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}
}