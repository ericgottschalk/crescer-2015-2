using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Optimization;

namespace Locadora.Web.MVC.App_Start
{
    public class BundleConfig
    {
        public static void RegisterBundles(BundleCollection bundles)
        {
            bundles.Add(new ScriptBundle("~/bundles/jquery").Include(
                        "~/Scripts/jquery-{version}.js",
                        "~/Scripts/jquery-ui-{version}.js"));

            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

            bundles.Add(new StyleBundle("~/Content/css").Include(
                        "~/Content/bootstrap.css",
                        "~/Content/Site.css",
                        "~/Content/StyleSheet.css"));

            bundles.Add(new StyleBundle("~/bundles/detalhesjogo").Include(
                        "~/Content/DetalhesJogo.css"));

            bundles.Add(new StyleBundle("~/bundles/index").Include(
                        "~/Content/Index.css"));

            bundles.Add(new StyleBundle("~/bundles/jogosdisponiveis").Include(
                         "~/Content/JogosDisponiveis.css"));

            bundles.Add(new StyleBundle("~/bundles/manterjogo").Include(
                         "~/Content/ManterJogo.css"));
        }
    }
}

    