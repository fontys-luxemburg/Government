(function(t){function e(e){for(var r,i,o=e[0],l=e[1],c=e[2],d=0,p=[];d<o.length;d++)i=o[d],a[i]&&p.push(a[i][0]),a[i]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(t[r]=l[r]);u&&u(e);while(p.length)p.shift()();return n.push.apply(n,c||[]),s()}function s(){for(var t,e=0;e<n.length;e++){for(var s=n[e],r=!0,o=1;o<s.length;o++){var l=s[o];0!==a[l]&&(r=!1)}r&&(n.splice(e--,1),t=i(i.s=s[0]))}return t}var r={},a={app:0},n=[];function i(e){if(r[e])return r[e].exports;var s=r[e]={i:e,l:!1,exports:{}};return t[e].call(s.exports,s,s.exports,i),s.l=!0,s.exports}i.m=t,i.c=r,i.d=function(t,e,s){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:s})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var s=Object.create(null);if(i.r(s),Object.defineProperty(s,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)i.d(s,r,function(e){return t[e]}.bind(null,r));return s},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/government/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],l=o.push.bind(o);o.push=e,o=o.slice();for(var c=0;c<o.length;c++)e(o[c]);var u=l;n.push([0,"chunk-vendors"]),s()})({0:function(t,e,s){t.exports=s("56d7")},"005a":function(t,e,s){},"56d7":function(t,e,s){"use strict";s.r(e);s("cadf"),s("551c"),s("f751"),s("097d");var r=s("2b0e"),a=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"app"}},[r("div",{staticClass:"bg-white p-2 border-b border-grey-light mb-8 flex justify-between items-center"},[r("router-link",{attrs:{to:"/"}},[r("img",{staticClass:"h-12",attrs:{alt:"Gouvernement du Grand-Duché de Luxembourg",src:s("f961")}})]),t.loggedIn?r("router-link",{staticClass:"flex items-center pr-8 no-underline text-black",attrs:{to:"/login"}},[r("div",[t._v(t._s(t.user.name))]),r("div",{staticClass:"bg-grey-light w-8 h-8 flex items-center justify-center rounded-full ml-4 text-sm"},[r("svg",{staticClass:"w-4 h-4 text-grey-dark",attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 24 24",fill:"none",stroke:"currentColor","stroke-width":"2","stroke-linecap":"round","stroke-linejoin":"round"}},[r("path",{attrs:{d:"M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"}}),r("circle",{attrs:{cx:"12",cy:"7",r:"4"}})])])]):t._e()],1),r("div",{staticClass:"container mx-auto px-4"},[r("router-view")],1)])},n=[],i=s("cebc"),o=s("2f62"),l={name:"app",computed:Object(i["a"])({},Object(o["b"])({loggedIn:function(t){return t.auth.status.loggedIn},user:function(t){return t.auth.user}}))},c=l,u=s("2877"),d=Object(u["a"])(c,a,n,!1,null,null,null),p=d.exports,h=(s("6762"),s("8c4f")),v=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"bg-white rounded p-8"},[s("div",{staticClass:"flex flex-col items-center"},[s("h1",{staticClass:"mb-8"},[t._v("Search vehicle information")]),s("form",{staticClass:"flex",attrs:{type:"get"},on:{submit:function(e){return e.preventDefault(),t.search(e)}}},[s("div",{staticClass:"flex bg-yellow text-xl inline-flex rounded overflow-hidden mr-4"},[s("div",{staticClass:"bg-blue p-2"},[s("svg",{staticClass:"stroke-current text-yellow",attrs:{height:"24",width:"24"}},[s("circle",{attrs:{cx:"12",cy:"12",r:"8","stroke-width":"2",fill:"transparent","stroke-dasharray":"0.001 5.6","stroke-linecap":"round"}})]),s("div",{staticClass:"text-white text-sm text-center"},[t._v("L")])]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.registrationID,expression:"registrationID"}],staticClass:"bg-transparent py-2 px-4 w-32 text-2xl",attrs:{type:"text",autofocus:"",placeholder:"AB-1234"},domProps:{value:t.registrationID},on:{input:function(e){e.target.composing||(t.registrationID=e.target.value)}}})]),s("button",{staticClass:"block bg-grey-light hover:bg-grey text-grey-darker group py-4 px-8 pr-6 rounded flex items-center",attrs:{type:"submit",disabled:0==t.registrationID.length}},[s("span",{staticClass:"mr-2"},[t._v("Search")]),s("svg",{staticClass:"text-grey-dark group-hover:text-grey-dark",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:"currentColor","stroke-width":"2","stroke-linecap":"round","stroke-linejoin":"round"}},[s("polyline",{attrs:{points:"9 18 15 12 9 6"}})])])])])])},m=[],f={name:"index",data:function(){return{registrationID:""}},methods:{search:function(){this.$router.push({name:"cars#show",params:{license_number:this.registrationID}})}}},g=f,b=Object(u["a"])(g,v,m,!1,null,"207f58c0",null),_=b.exports,C=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[t.status.loading?s("div",{staticClass:"flex justify-center items-center my-32"},[s("MoonLoader",{attrs:{color:"black"}})],1):t._e(),t.status.loaded?s("div",[s("car-header"),t._m(0)],1):t._e(),t.status.failed?s("div",{staticClass:"flex items-center justify-center flex-col mt-32"},[s("h1",{staticClass:"mb-8"},[t._v("We couldn't find this vehicle")]),s("router-link",{staticClass:"bg-blue p-4 rounded text-white no-underline hover:bg-blue-dark",attrs:{to:"/"}},[t._v("Search for other vehicle")])],1):t._e()])},w=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"bg-white rounded p-8"},[s("h2",{staticClass:"mb-4"},[t._v("Vehicle information")]),s("table",{staticClass:"w-full"},[s("tr",{staticClass:"border-b border-grey-lighter"},[s("td",{staticClass:"py-4"},[t._v("Vehicle category")]),s("td",{staticClass:"py-4 w-2/3"},[t._v("Car")])]),s("tr",{staticClass:"border-b border-grey-lighter"},[s("td",{staticClass:"py-4"},[t._v("Suspension type")]),s("td",{staticClass:"py-4 w-2/3"},[t._v("Hatchback")])]),s("tr",{staticClass:"border-b border-grey-lighter"},[s("td",{staticClass:"py-4"},[t._v("Brand")]),s("td",{staticClass:"py-4 w-2/3"},[t._v("PEUGEOT")])]),s("tr",{staticClass:"border-b border-grey-lighter"},[s("td",{staticClass:"py-4"},[t._v("Type")]),s("td",{staticClass:"py-4 w-2/3"},[t._v("C")])]),s("tr",[s("td",{staticClass:"py-4"},[t._v("Color")]),s("td",{staticClass:"py-4 w-2/3"},[t._v("Grey")])])])])}],y=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",{staticClass:"mb-2"},[s("router-link",{staticClass:"no-underline text-grey-dark inline-flex items-center hover:text-grey-darker",attrs:{to:"/"}},[s("svg",{staticClass:"feather feather-chevron-left",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:"currentColor","stroke-width":"2","stroke-linecap":"round","stroke-linejoin":"round"}},[s("polyline",{attrs:{points:"15 18 9 12 15 6"}})]),t._v("\n      Back\n    ")])],1),s("div",{staticClass:"bg-white rounded mb-8"},[s("div",{staticClass:"p-8"},[s("h1",{staticClass:"mb-2"},[t._v(t._s(t.vehicle.brand))]),s("h2",[t._v(t._s(t.vehicle.model)+" – "+t._s(t.vehicle.registrationID))])]),s("div",{staticClass:"flex px-4"},[s("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#show",params:{license_number:t.vehicle.registrationID}}}},[t._v("Basic")]),s("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#trackers",params:{license_number:t.vehicle.registrationID}}}},[t._v("Trackers")]),s("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#owner",params:{license_number:t.vehicle.registrationID}}}},[t._v("Owner")]),s("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#travels",params:{license_number:t.vehicle.registrationID}}}},[t._v("Travels")])],1)])])},x=[],k={name:"car-header",computed:Object(i["a"])({},Object(o["b"])({vehicle:function(t){return t.vehicles.value}}))},E=k,S=(s("7d38"),Object(u["a"])(E,y,x,!1,null,"7584663c",null)),I=S.exports,O=s("2fc2"),j={name:"cars-show",components:{CarHeader:I,MoonLoader:O["a"]},computed:Object(i["a"])({},Object(o["b"])({vehicle:function(t){return t.vehicles.value},status:function(t){return t.vehicles.status}})),created:function(){this.$store.dispatch("vehicles/getVehicle",this.$route.params.license_number)}},T=j,L=Object(u["a"])(T,C,w,!1,null,null,null),U=L.exports,P=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("car-header"),t._m(0)],1)},$=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"bg-white rounded p-8"},[s("h2",{staticClass:"mb-8"},[t._v("Tracker History")]),s("table",{staticClass:"w-full"},[s("thead",{staticClass:"border-b-2 border-grey"},[s("tr",{staticClass:"font-normal"},[s("td",{staticClass:"py-4"},[t._v("Tracker ID")]),s("td",{staticClass:"py-4"},[t._v("Type")]),s("td",{staticClass:"py-4"},[t._v("Installed on")]),s("td",{staticClass:"py-4"},[t._v("Status")])])]),s("tbody",[s("tr",[s("td",{staticClass:"py-4"},[t._v("a28594b0-dc70-4745-9e54-b3b3fb61c437")]),s("td",{staticClass:"py-4"},[t._v("Trax P1")]),s("td",{staticClass:"py-4"},[t._v("27-03-2014")]),s("td",{staticClass:"py-4"},[s("div",{staticClass:"uppercase bg-green-lightest inline-block p-2 text-xs text-green-dark tracking-wide font-bold rounded"},[t._v("active")])])])])])])}],H={name:"Trackers",components:{CarHeader:I}},D=H,N=Object(u["a"])(D,P,$,!1,null,"763cb971",null),R=N.exports,G=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("car-header"),t.status.loaded?s("div",{staticClass:"bg-white rounded p-8"},[s("h2",{staticClass:"mb-2"},[t._v("Ownership history")]),s("table",{staticClass:"w-full"},[t._m(0),s("tbody",t._l(t.ownerships,function(e){return s("tr",{key:e.id},[s("td",{staticClass:"py-4"},[t._v(t._s(e.userID))]),s("td",{staticClass:"py-4"},[t._v(t._s(e.createdAt))]),s("td",{staticClass:"py-4"},[t._v(t._s(e.endDate))])])}),0)])]):t._e()],1)},V=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("thead",{staticClass:"border-b-2 border-grey"},[s("tr",{staticClass:"font-normal"},[s("td",{staticClass:"py-4"},[t._v("Owner")]),s("td",{staticClass:"py-4"},[t._v("From")]),s("td",{staticClass:"py-4"},[t._v("Until")])])])}],A={name:"Owner",components:{CarHeader:I},computed:Object(i["a"])({},Object(o["b"])({ownerships:function(t){return t.ownerships.all},status:function(t){return t.ownerships.status}})),created:function(){this.$store.dispatch("ownerships/getOwnerships",this.$route.params.license_number)}},B=A,F=Object(u["a"])(B,G,V,!1,null,"309f2838",null),M=F.exports,W=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("car-header")},Q=[],J={name:"Travels",components:{CarHeader:I}},z=J,q=Object(u["a"])(z,W,Q,!1,null,"c9377fc0",null),K=q.exports,X=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"max-w-sm mx-auto"},[s("div",{staticClass:"bg-white rounded p-6 mb-8"},[s("h1",{staticClass:"text-center mb-8"},[t._v("Login")]),s("form",{on:{submit:function(e){return e.preventDefault(),t.handleSubmit(e)}}},[s("div",{staticClass:"mb-4"},[s("label",{staticClass:"block mb-2"},[t._v("Email")]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],staticClass:"bg-grey-lightest p-4 block rounded w-full",attrs:{type:"text",placeholder:"Email"},domProps:{value:t.email},on:{input:function(e){e.target.composing||(t.email=e.target.value)}}})]),s("div",{staticClass:"mb-8"},[s("label",{staticClass:"block mb-2"},[t._v("Password")]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],staticClass:"bg-grey-lightest p-4 block rounded w-full",attrs:{type:"password",placeholder:"Password"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),s("button",{staticClass:"w-full bg-blue p-4 rounded text-white",attrs:{disabled:t.loggingIn}},[t._v("Log in")])])])])},Y=[],Z={name:"login",data:function(){return{email:"",password:"",submitted:!1}},computed:{loggingIn:function(){return this.$store.state.auth.status.loggingIn}},created:function(){this.$store.dispatch("auth/logout")},methods:{handleSubmit:function(t){this.submitted=!0;var e=this.email,s=this.password,r=this.$store.dispatch;e&&s&&r("auth/login",{email:e,password:s})}}},tt=Z,et=Object(u["a"])(tt,X,Y,!1,null,"6c672456",null),st=et.exports;r["a"].use(h["a"]);var rt=new h["a"]({routes:[{path:"/",name:"index",component:_},{path:"/login",name:"login",component:st},{path:"/cars/:license_number",name:"cars#show",component:U},{path:"/cars/:license_number/trackers",name:"cars#trackers",component:R},{path:"/cars/:license_number/owner",name:"cars#owner",component:M},{path:"/cars/:license_number/travels",name:"cars#travels",component:K}]});rt.beforeEach(function(t,e,s){var r=["/login"],a=!r.includes(t.path),n=localStorage.getItem("user");if(a&&!n)return s("/login");s()});var at=s("795b"),nt=s.n(at);function it(){var t=JSON.parse(localStorage.getItem("user"));return t&&t.token?{Authorization:"Bearer "+t.token}:{}}var ot=s("f499"),lt=s.n(ot),ct={login:ut,logout:dt};function ut(t,e){var s={method:"POST",headers:{"Content-Type":"application/json"},body:lt()({email:t,password:e})};return fetch("/government/api/authentication",s).then(pt).then(function(t){return t.token&&localStorage.setItem("user",lt()(t)),t})}function dt(){localStorage.removeItem("user")}function pt(t){var e=t.json();if(!t.ok){401===t.status&&dt();var s=e&&e.message||t.statusText;return nt.a.reject(s)}return e}var ht={findVehicle:vt};function vt(t){var e={method:"GET",headers:it()};return fetch("/government/api/vehicles/".concat(t),e).then(mt).then(function(t){return t})}function mt(t){var e=t.json();if(!t.ok){401===t.status&&ct.logout();var s=e&&e.message||t.statusText;return nt.a.reject(s)}return e}var ft={findOwnerships:gt};function gt(t){var e={method:"GET",headers:it()};return fetch("/government/api/vehicles/".concat(t,"/ownerships"),e).then(bt).then(function(t){return t})}function bt(t){var e=t.json();if(!t.ok){401===t.status&&ct.logout();var s=e&&e.message||t.statusText;return nt.a.reject(s)}return e}var _t={value:null,status:{}},Ct={getVehicle:function(t,e){var s=t.commit;s("VEHICLE_REQUEST"),ht.findVehicle(e).then(function(t){s("VEHICLE_SUCCESS",t)}).catch(function(t){s("VEHICLE_FAILURE")})}},wt={VEHICLE_REQUEST:function(t){t.value=null,t.status={loading:!0}},VEHICLE_SUCCESS:function(t,e){t.status={loaded:!0},t.value=e},VEHICLE_FAILURE:function(t){t.value=null,t.status={failed:!0}}},yt={namespaced:!0,state:_t,actions:Ct,mutations:wt},xt={all:[],status:{}},kt={getOwnerships:function(t,e){var s=t.commit;s("OWNERSHIPS_REQUEST"),ft.findOwnerships(e).then(function(t){s("OWNERSHIPS_SUCCESS",t)}).catch(function(){s("OWNERSHIPS_FAILURE")})}},Et={OWNERSHIPS_REQUEST:function(t){t.all=[],t.status={loading:!0}},OWNERSHIPS_SUCCESS:function(t,e){t.status={loaded:!0},t.all=e},OWNERSHIPS_FAILURE:function(t){t.value=null,t.status={failed:!0}}},St={namespaced:!0,state:xt,actions:kt,mutations:Et},It=JSON.parse(localStorage.getItem("user")),Ot=It?{status:{loggedIn:!0},user:It}:{status:{},user:null},jt={login:function(t,e){var s=t.dispatch,r=t.commit,a=e.email,n=e.password;r("LOGIN_REQUEST",{email:a}),ct.login(a,n).then(function(t){r("LOGIN_SUCCESS",t),rt.push("/")}).catch(function(t){r("LOGIN_FAILURE",t),s("notices/addNotice",t,{root:!0})})},logout:function(t){var e=t.commit;ct.logout(),e("LOGOUT")}},Tt={LOGIN_REQUEST:function(t,e){t.status={loggingIn:!0},t.user=e},LOGIN_SUCCESS:function(t,e){t.status={loggedIn:!0},t.user=e},LOGIN_FAILURE:function(t){t.status={},t.user=null},LOGOUT:function(t){t.status={},t.user=null}},Lt={namespaced:!0,state:Ot,actions:jt,mutations:Tt};r["a"].use(o["a"]);var Ut=new o["a"].Store({modules:{vehicles:yt,ownerships:St,auth:Lt},strict:!0});s("def6");r["a"].config.productionTip=!1,new r["a"]({router:rt,store:Ut,render:function(t){return t(p)}}).$mount("#app")},"7d38":function(t,e,s){"use strict";var r=s("005a"),a=s.n(r);a.a},def6:function(t,e,s){},f961:function(t,e,s){t.exports=s.p+"img/gov-light-2x.a84643c6.png"}});
//# sourceMappingURL=app.23f23eb5.js.map