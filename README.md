# Shopping List Web App

体验更好地做软件。

自我介绍一下。我笔名吾真本，本名伍斌。独立软件开发咨询师。“吾真本说混沌工程”知乎专栏主，专注软件系统稳定性设计。《混沌工程》合译者，《发布！》第2版译者。从业30年，做过开发、测试、项目管理、软件开发咨询。2014～2022年曾在Thoughtworks做过8年软件开发技术教练。帮助几十家企业的IT部门，落地持续集成和自动化测试等敏捷软件工程和DevOps工程实践。

从2023年8月到10月，我花了3个月自学docker和k8s。踩了一路坑，到10月22日终于把一个带有vue.js 3前端、spring boot后端以及postgres数据库的shopping list web app，部署到azure k8s service云上，并能正常运行。

之所以说踩了一路坑，是因为网上分享的k8s部署web app的样例，都是部署一个web服务。即使讲ingress nginx controller的样例会涉及两个微服务，但在这种根据path设定将请求分配给两个hello world的web微服务场景，两个微服务之间，是没有前后端之间的依赖关系的。另外前后端之间的CORS跨源资源共享该如何解决，也找不到我这种前后端分离的web app场景下的直接资料，只能自己摸索。

在爬出坑后，很愿意写一系列避坑指南文章分享给大家。虽然不知小伙伴们是否愿意读，但我很想把这一系列文章，写成世界上通过实例讲docker和k8s入门的最好的文章，而且每年至少更新一次。

系列文章的目标读者，是对docker或k8s不太熟悉的做软件的人，包括程序员，测试工程师和运维工程师。

如果你对java和vue.js不熟，也不要紧，因为代码命名写得足够表意，一看就懂。另外，本系列文章不涉及前后端具体的编程，而重点关注如何把开发好的代码用docker打成image，并部署到docker compose和k8s上。这些都与前后端所使用的编程语言关系不大，所以本文内容适用于所有前后端分离的web app的技术栈。

这一系列文章可以分为三篇，每一篇都分别有Ubuntu、macOS和Windows 10三个版本。这三篇的标题和大纲如下：

* K8s部署前后端分离的web app避坑系列指南之一：在本地开发环境、docker compose和k8s云集群里跑通（2023版）

  - 太长不读

    本文目标读者有哪些？做软件的人，主要针对不太熟悉docker或k8s的程序员、测试工程师、运维工程师
    
    K8s和Docker能解决做软件的人的什么痛点？体验更好地做软件。“在我这运行得好好的，怎么你那儿不行？”“这是谁改了配置又不告诉大家？”“测试环境太少得排队使用”

    为何选用Shopping List Web app作为样例项目？源自todo list，功能简单，容易理解；能代表前后端分离的web app典型架构；能表现最小化的云原生微服务之间的依赖关系，便于学习混沌工程故障注入实验工具

    不会编程能读懂本文吗？不涉及前后端功能的代码编写，而主要涉及配置文件和命令行工具的使用，适合程序员、测试工程师和运维工程师阅读。

    我是做测试或运维的，还需要在本地开发环境里跑通吗？需要。因为当你需要在源代码里更改配置，并重新构建docker image时，你就学会了该如何操作。

    本文所基于的Ubuntu/macOS/Windows10这3种开发环境简介

    如何验证在本地开发环境里跑通

  - 深入阅读
    
    要部署k8s的Shopping List Web App的功能简介
    
    Shopping List Web App在本地开发环境里的架构 (c4 model)

    从源代码小步部署到k8s的步骤：先在本地开发环境里跑通，然后在docker compose里跑通，最后在云k8s集群里跑通

    本地开发环境准备（Ubuntu/macOS/Windows10版先后写）

    在本地开发环境里跑通（Ubuntu/macOS/Windows10版先后写）

    Docker compose环境准备（Ubuntu/macOS/Windows10版先后写）

    在docker compose里跑通（Ubuntu/macOS/Windows10版先后写）

    K8s云集群环境准备（Ubuntu/macOS/Windows10版先后写）

    在k8s云集群里跑通（Ubuntu/macOS/Windows10版先后写）

* K8s部署前后端分离的web app避坑系列指南之二：解读Dockerfile和docker-compose.yml文件（2023版）

  - 太长不读

    Shopping List Web App在docker compose里的架构 (c4 model)

  - 深入阅读
  
    解读Dockerfile
    
    解读docker-compose.yml文件
    
* K8s部署前后端分离的web app避坑系列指南之三：解读k8s的deployment、service和ingress配置文件（2023版）

  - 太长不读

    Shopping List Web App在k8s云集群里的架构 (c4 model)

  - 深入阅读
    
    解读k8s的deployment配置文件
    
    解读k8s的service配置文件
    
    解读k8s的ingress配置文件

如果你喜欢这篇文章，欢迎点赞和收藏，并在留言区写下为何喜欢，以便我将来写更多你喜欢的文章。

如果你不喜欢，也欢迎你留言告诉我哪里可以再改进。

也可以 v - x i n 我 wubinben28，备注“k8s”。
	