"use strict";(self["webpackChunkvue3_nb0"]=self["webpackChunkvue3_nb0"]||[]).push([[460],{9075:(e,l,t)=>{var n=t(5378),a=t(5039),o=t(1813),u=t(9504),r=t(7095),i=t(6522),s=t(3560),v=t(2525),c=t(2065),d=t(4255),f=t(8661),p=t(5201),m=f("isConcatSpreadable"),g=p>=51||!a((function(){var e=[];return e[m]=!1,e.concat()[0]!==e})),w=function(e){if(!u(e))return!1;var l=e[m];return void 0!==l?!!l:o(e)},_=!g||!d("concat");n({target:"Array",proto:!0,arity:1,forced:_},{concat:function(e){var l,t,n,a,o,u=r(this),d=c(u,0),f=0;for(l=-1,n=arguments.length;l<n;l++)if(o=-1===l?u:arguments[l],w(o))for(a=i(o),s(f+a),t=0;t<a;t++,f++)t in o&&v(d,f,o[t]);else s(f+1),v(d,f++,o);return d.length=f,d}})},7460:(e,l,t)=>{t.r(l),t.d(l,{default:()=>y});t(4580),t(9075),t(1781);var n=t(4401),a=t(8849),o=t(4899),u=t(1066),r=function(e){return(0,n.dD)("data-v-750b2109"),e=e(),(0,n.Cn)(),e},i={class:"login_view"},s=r((function(){return(0,n._)("div",{class:"outTitle_view"},[(0,n._)("div",{class:"outTilte"},"物流系统登录")],-1)})),v={key:0,class:"tabView"},c=["onClick"],d={key:1,class:"list_item"},f=r((function(){return(0,n._)("div",{class:"list_label"}," 账号： ",-1)})),p={key:2,class:"list_item"},m=r((function(){return(0,n._)("div",{class:"list_label"}," 密码： ",-1)})),g=["onKeydown"],w={class:"btn_view"};const _={__name:"login",setup:function(e){var l,t=(0,u.iH)([]),r=(0,u.iH)([]),_=(0,u.iH)({role:"",username:"",password:""}),h=(0,u.iH)(""),k=(0,u.iH)(1),y=null===(l=(0,n.FN)())||void 0===l?void 0:l.appContext.config.globalProperties,b=function(e){null===y||void 0===y||y.$router.push("/".concat(e,"Register"))},U=function(e){_.value.role=e},N=function(){if(_.value.username)if(_.value.password){if(t.value.length>1){if(!_.value.role)return null===y||void 0===y||y.$toolUtil.message("请选择角色","error"),void verifySlider.value.reset();for(var e=0;e<r.value.length;e++)r.value[e].roleName==_.value.role&&(h.value=r.value[e].tableName)}else h.value=t.value[0].tableName,_.value.role=t.value[0].roleName;$()}else null===y||void 0===y||y.$toolUtil.message("请输入密码","error");else null===y||void 0===y||y.$toolUtil.message("请输入用户名","error")},$=function(){null===y||void 0===y||y.$http({url:"".concat(h.value,"/login?username=").concat(_.value.username,"&password=").concat(_.value.password),method:"post"}).then((function(e){null===y||void 0===y||y.$toolUtil.storageSet("Token",e.data.token),null===y||void 0===y||y.$toolUtil.storageSet("role",_.value.role),null===y||void 0===y||y.$toolUtil.storageSet("sessionTable",h.value),null===y||void 0===y||y.$toolUtil.storageSet("adminName",_.value.username),null===y||void 0===y||y.$router.push("/")}),(function(e){}))},C=function(){var e={page:1,limit:1,sort:"id"};null===y||void 0===y||y.$http({url:"menu/list",method:"get",params:e}).then((function(e){r.value=JSON.parse(e.data.data.list[0].menujson);for(var l=0;l<r.value.length;l++)"是"==r.value[l].hasBackLogin&&t.value.push(r.value[l]);_.value.role=t.value[0].roleName,null===y||void 0===y||y.$toolUtil.storageSet("menus",JSON.stringify(r.value))}))},S=function(){C()};return(0,n.bv)((function(){S()})),function(e,l){var u=(0,n.up)("el-button"),r=(0,n.up)("el-form");return(0,n.wg)(),(0,n.iD)("div",null,[(0,n._)("div",i,[s,(0,n.Wm)(r,{model:_.value,class:"login_form"},{default:(0,n.w5)((function(){return[t.value.length>1?((0,n.wg)(),(0,n.iD)("div",v,[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(t.value,(function(e,l){return(0,n.wg)(),(0,n.iD)("div",{class:(0,a.C_)(["tab",_.value.role==e.roleName?"tabActive":""]),style:(0,a.j5)({width:"calc(100% / ".concat(t.value.length,")")}),key:l,onClick:function(l){return U(e.roleName)}},(0,a.zw)(e.roleName),15,c)})),128))])):(0,n.kq)("",!0),1==k.value?((0,n.wg)(),(0,n.iD)("div",d,[f,(0,n.wy)((0,n._)("input",{class:"list_inp","onUpdate:modelValue":l[0]||(l[0]=function(e){return _.value.username=e}),placeholder:"请输入账号"},null,512),[[o.nr,_.value.username]])])):(0,n.kq)("",!0),1==k.value?((0,n.wg)(),(0,n.iD)("div",p,[m,(0,n.wy)((0,n._)("input",{class:"list_inp","onUpdate:modelValue":l[1]||(l[1]=function(e){return _.value.password=e}),type:"password",placeholder:"请输入密码",onKeydown:(0,o.D2)(N,["enter","native"])},null,40,g),[[o.nr,_.value.password]])])):(0,n.kq)("",!0),(0,n._)("div",w,[1==k.value?((0,n.wg)(),(0,n.j4)(u,{key:0,class:"login",type:"success",onClick:N},{default:(0,n.w5)((function(){return[(0,n.Uk)("登录")]})),_:1})):(0,n.kq)("",!0),(0,n.Wm)(u,{class:"register",type:"primary",onClick:l[2]||(l[2]=function(e){return b("siji")})},{default:(0,n.w5)((function(){return[(0,n.Uk)("注册司机")]})),_:1}),(0,n.Wm)(u,{class:"register",type:"primary",onClick:l[3]||(l[3]=function(e){return b("kehu")})},{default:(0,n.w5)((function(){return[(0,n.Uk)("注册客户")]})),_:1})])]})),_:1},8,["model"])])])}}};var h=t(1059);const k=(0,h.Z)(_,[["__scopeId","data-v-750b2109"]]),y=k}}]);
//# sourceMappingURL=460.f1cf180d.js.map