<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta content="initial-scale=1.0, width=device-width" name="viewport" />

<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div id="wrapper">
    <header class="container-fluid-1280" id="banner" role="banner">
        <div class="row">
            <div class="navbar-header" id="heading">
                <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
                </a>

			<!--<#if show_site_name>
                <span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				${site_name}
					</span>
			</#if>-->

			<#if is_setup_complete>
                <button aria-controls="navigation" aria-expanded="false" class="collapsed navbar-toggle" data-target="#navigationCollapse" data-toggle="collapse" type="button">
                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>
                </button>

                <div class="pull-right user-personal-bar">
					<@liferay.user_personal_bar />
                </div>
			</#if>
            </div>

		<#include "${full_templates_path}/navigation.ftl" />
        </div>
    </header>

    <section class="container-fluid-1280" id="content">
        <h1 class="hide-accessible">${the_title}</h1>

	<#if selectable>
		<@liferay_util["include"] page=content_include />
	<#else>
	${portletDisplay.recycle()}

	${portletDisplay.setTitle(the_title)}

		<@liferay_theme["wrap-portlet"] page="portlet.ftl">
			<@liferay_util["include"] page=content_include />
		</@>
	</#if>
    </section>

    <footer class="container-fluid-1280" id="footer" role="contentinfo">
        <div class="row" style="font-size: 12px;">
            <div class="contentFot">
                <span style="font-weight: bold;">SEDE ADMINISTRATIVA</span><br>
                Dirección general: Carrera 13 No. 26A - 85 Bogota<br>
                Conmutador: 339 3000<br>
                Línea de atención en Bogotá 3073422<br>
                <a href="#" target="_blank">Mapa del Sitio</a> | <a href="#" target="_blank">Politicas de privacidad</a> | <a href="#" target="_blank">Condiciones de uso del sitio</a>
            </div>
            <div class="col2">
                <!--<div class="superI"><a class="super" target="_blank" href="#" ></a></div>-->
                <div class="social">
                    Siguenos en: <a class="yt" target="_blank" href="http://www.youtube.com/" ></a> <a class="tw" target="_blank" href="https://twitter.com/" ></a>
                </div>
            </div>
        </div>
    </footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>